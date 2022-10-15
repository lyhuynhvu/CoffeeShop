package GUI;

import BUS.ExportBillBUS;
import DTO.ExportBillDTO;
import java.io.*;
import java.util.List;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportBill {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.BLACK.getIndex());

        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);

        return style;
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    public static void run(int parentId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Hóa đơn");

        ExportBillBUS ex = new ExportBillBUS();
        List<ExportBillDTO> list = ex.bill(parentId);

        Row row;
        Cell cell;

        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("HÓA ĐƠN THANH TOÁN");
        cell.setCellStyle(createStyleForTitle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        int n1 = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, n1);

        row = sheet.createRow(1);
        styleBackground(workbook, cell, row);

        row = sheet.createRow(2);
        styleBackground(workbook, cell, row);
        row.getCell(1).setCellValue("Ngày tạo: " + list.get(0).getDate());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
        int n2 = sheet.getRow(2).getPhysicalNumberOfCells();
        autosizeColumn(sheet, n2);

        row = sheet.createRow(3);
        styleBackground(workbook, cell, row);
        row.getCell(1).setCellValue("Nhân viên: " + list.get(0).getBy());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 2));
        int n3 = sheet.getRow(3).getPhysicalNumberOfCells();
        autosizeColumn(sheet, n3);

        row = sheet.createRow(4);
        styleBackground(workbook, cell, row);

        row = sheet.createRow(5);
        cell = row.createCell(0);
        cell.setCellStyle(styleForHead(workbook));
        cell = row.createCell(1);
        cell.setCellStyle(styleForHead(workbook));
        cell.setCellValue("Món");

        cell = row.createCell(2);
        cell.setCellStyle(styleForHead(workbook));
        cell.setCellValue("Đơn giá");

        cell = row.createCell(3);
        cell.setCellStyle(styleForHead(workbook));
        cell.setCellValue("Số lượng");

        cell = row.createCell(4);
        cell.setCellStyle(styleForHead(workbook));
        cell.setCellValue("Thành tiền");

        cell = row.createCell(5);
        cell.setCellStyle(styleForHead(workbook));

        int n5 = sheet.getRow(5).getPhysicalNumberOfCells();
        autosizeColumn(sheet, n5);

        int rownum = 6;

        for (ExportBillDTO e : list) {
            row = sheet.createRow(rownum);
            styleBackground(workbook, cell, row);

            row.getCell(1).setCellValue(e.getItem());
            row.getCell(2).setCellValue(e.getPrice());
            row.getCell(3).setCellValue(e.getQuanity());
            row.getCell(4).setCellValue(e.getSubtotal());

            int n = sheet.getRow(rownum).getPhysicalNumberOfCells();
            autosizeColumn(sheet, n);

            rownum++;
        }

        row = sheet.createRow(rownum);
        styleBackground(workbook, cell, row);

        row = sheet.createRow(rownum + 1);
        cell = row.createCell(0);
        cell.setCellStyle(createStyleForTitle(workbook));

        cell = row.createCell(1);
        cell.setCellValue("Tổng tiền:");
        cell.setCellStyle(createStyleForTitle(workbook));

        cell = row.createCell(2);
        cell.setCellStyle(createStyleForTitle(workbook));

        cell = row.createCell(3);
        cell.setCellStyle(createStyleForTitle(workbook));

        cell = row.createCell(4, CellType.NUMERIC);
        cell.setCellValue(list.get(0).getSum());
        cell.setCellStyle(createStyleForTitle(workbook));

        cell = row.createCell(5);
        cell.setCellStyle(createStyleForTitle(workbook));

        row = sheet.createRow(rownum + 2);
        styleBackground(workbook, cell, row);

        row = sheet.createRow(rownum + 3);
        cell = row.createCell(0);
        cell.setCellStyle(createStyleForTitle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(rownum + 3, rownum + 3, 0, 5));
        cell.setCellValue("CẢM ƠN! HẸN GẶP LẠI");

        row = sheet.createRow(rownum + 4);
        styleBackground(workbook, cell, row);

        int random = (int) (Math.random() * 1000);
        String fileName = "HoaDon" + String.valueOf(random);
        File file = new File("D:/" + fileName + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }

    private static HSSFCellStyle styleForHead(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());

        HSSFCellStyle styles = workbook.createCellStyle();
        styles.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        styles.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styles.setAlignment(HorizontalAlignment.CENTER);
        styles.setFont(font);

        return styles;
    }

    private static void styleBackground(HSSFWorkbook workbook, Cell cell, Row row) {
        for (int col = 0; col <= 5; col++) {
            cell = row.createCell(col);
            HSSFCellStyle s = workbook.createCellStyle();
            s.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(s);
        }
    }
}
