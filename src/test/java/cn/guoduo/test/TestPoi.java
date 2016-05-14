package cn.guoduo.test;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @athor Lijian
 * @date 2016年05月13日
 */
public class TestPoi {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/book/test.xls");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("ceshi");
        Row row = sheet.createRow(0);
        row.createCell(0, Cell.CELL_TYPE_STRING).setCellValue("1");
        book.write(out);
        out.flush();

    }
}
