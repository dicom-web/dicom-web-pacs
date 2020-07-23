package net.lainiao.dicom.common.utils;

import com.dexhin.fact.entity.ext.ExcelData;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author shl
 * @Date 2020/3/10
 */
public class ExcelUtils {
    /**
     * 下载文件
     * @param response
     * @param fileName
     * @param data
     * @throws Exception
     */
    public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setContentType("octets/stream");
        response.setContentType("APPLICATION/OCTET-STREAM");
        exportExcel(data, response.getOutputStream());
    }

    /**
     * 创建 表格
     * @param data
     * @param out
     * @throws Exception
     */
    public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        try {
            String sheetName = null;
            if (null == sheetName) {
                sheetName = "Sheet1";
            }
            XSSFSheet sheet = wb.createSheet(sheetName);
            writeExcel(wb, sheet, data);
            wb.write(out);
        } finally {
            out.flush();
            out.close();
            wb.close();
        }
    }

    /**
     * 将数据写入表格
     * @param wb
     * @param sheet
     * @param data
     */
    private static void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data) {
        int rowIndex = 0;
        rowIndex = writeTitlesToExcel(wb, sheet, data.getTitles());
        writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
        autoSizeColumns(sheet, data.getTitles().size() + 1);
    }

    /**
     * 写入表头
     * @param wb
     * @param sheet
     * @param titles
     * @return
     */
    private static int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<String> titles) {
        int rowIndex = 0;
        int colIndex = 0;
        Font titleFont = wb.createFont();//获取字体
        titleFont.setFontName("simsun");//设置字体名称（宋体）
        titleFont.setBold(true);//设置字体加粗
        titleFont.setColor(IndexedColors.BLACK.index);//设置字体颜色 黑色
        XSSFCellStyle titleStyle = wb.createCellStyle();//获取单元格样式
        titleStyle.setAlignment(HorizontalAlignment.CENTER);//设置单元格的水平对齐类型(这里是水平居中)
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//设置单元格的垂直对齐类型（这里是居中）
        titleStyle.setFillForegroundColor(createXssfColor("#FFFFFF"));//设置单元格前景色（白色）
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//指定图案和纯色单元格填充的单元格填充信息（实心前景）
        titleStyle.setFont(titleFont);//设置字体样式
        setBorder(titleStyle, BorderStyle.THIN, createXssfColor("#000000"));//设置边框样式（细线、黑色）
        Row titleRow = sheet.createRow(rowIndex);//在该工作簿中创建第一行.
        colIndex = 0;
        for (String field : titles) {//循环创建列
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }
        rowIndex++;//将行数++ 返回用于下面添加数据
        return rowIndex;
    }

    /**
     * 将数据写入
     * @param wb
     * @param sheet
     * @param rows
     * @param rowIndex
     * @return
     */
    private static int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<List<Object>> rows, int rowIndex) {
        int colIndex = 0;
        Font dataFont = wb.createFont();//获取字体
        dataFont.setFontName("simsun");//设置字体名称（宋体）
        dataFont.setColor(IndexedColors.BLACK.index);//设置字体颜色 黑色
        XSSFCellStyle dataStyle = wb.createCellStyle();//获取单元格样式
        dataStyle.setWrapText(true);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);//设置单元格的水平对齐类型(这里是水平居中)
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);//设置单元格的垂直对齐类型（这里是居中）
        dataStyle.setFont(dataFont);//设置字体样式
        setBorder(dataStyle, BorderStyle.THIN, createXssfColor("#000000"));//设置边框样式（细线、黑色）
        for (List<Object> rowData : rows) {//循环写入数据
            Row dataRow = sheet.createRow(rowIndex);
            colIndex = 0;
            for (Object cellData : rowData) {
                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
                    cell.setCellValue(cellData.toString());
                } else {
                    cell.setCellValue("");
                }
                cell.setCellStyle(dataStyle);
                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }

    /**
     * 自动调整大小
     * @param sheet
     * @param columnNumber
     */
    private static void autoSizeColumns(Sheet sheet, int columnNumber) {
        for (int i = 0; i < columnNumber; i++) {
            int colWidth = sheet.getColumnWidth(i) * 2;
            sheet.autoSizeColumn(i, true);
            if(colWidth < 255 * 856){
                sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
            }else{
                sheet.setColumnWidth(i,6000 );
            }
        }
    }

    /**
     * 设置表格样式
     * @param style
     * @param border
     * @param color
     */
    private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
        style.setBorderBottom(border);
        style.setBorderColor(XSSFCellBorder.BorderSide.TOP, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, color);
    }

    /**
     * 将rgb颜色码 转换为 XSSFColor
     * @param color
     * @return
     */
    private static XSSFColor createXssfColor(String color) {
        int[] rgbColor = hexToRgb(color);
        XSSFColor xssfColor = new XSSFColor(new java.awt.Color(rgbColor[0], rgbColor[1], rgbColor[2]), new DefaultIndexedColorMap());
        return xssfColor;
    }

    /**
     * 将颜色码 转换为 r g b
     * @param hex
     * @return
     */
    public static int[] hexToRgb(String hex) {
        String colorStr = hex;
        if (hex.startsWith("#")) {
            colorStr = hex.substring(1);
        }
        if (StringUtils.length(colorStr) == 8) {
            colorStr = hex.substring(2);
        }
        int  r=  Integer.valueOf( colorStr.substring( 0, 2 ), 16 );
        int  g=  Integer.valueOf( colorStr.substring( 2, 4 ), 16 );
        int  b=  Integer.valueOf( colorStr.substring( 4, 6 ), 16 );

        return new int[] { r, g, b };
    }

}
