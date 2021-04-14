package com.polymart.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class EntityExcel {
	public String getCurrenDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("_dd_MM_yyyy");  
	    Date date = new Date();  
	    return formatter.format(date);
	}
	private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
	//Xuất file Excel
	public void exportExcel(JTable table) throws IOException {
		Workbook newExcel = new XSSFWorkbook();
		Sheet sheet = newExcel.createSheet();
		Row rowHeader = sheet.createRow(0);
		for(int i=0;i<table.getColumnCount();i++) {
			Cell cellHeader = rowHeader.createCell(i);
			cellHeader.setCellValue(table.getColumnName(i));
			cellHeader.setCellStyle(createStyleForHeader(sheet));
		}
		
		for(int i=1;i<table.getRowCount();i++) {
			Row row = sheet.createRow(i);
			for(int j=0;j<table.getColumnCount();j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(table.getValueAt(i, j).toString());;
			}
		}
		for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
		    sheet.autoSizeColumn(columnIndex);
		}
		OutputStream os = new FileOutputStream(ChooseFileSave());
		newExcel.write(os);
		newExcel.close();
		os.close();
	}
	//Nhập file Excel
	public void importExcel(DefaultTableModel model) throws IOException {
		//InputStream inputStream = new FileInputStream(new File(ChooseFileOpen()));
		Workbook excel = new XSSFWorkbook(ChooseFileOpen());
		Sheet sheet = excel.getSheetAt(0);
		Row fistRow = sheet.getRow(0);
		Iterator<Cell> cellIterator = fistRow.cellIterator();
		int colCount = 0;
		while(cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			colCount++;
			if(!cellIterator.hasNext()) {
				break;
			}
		}
		System.out.println(colCount);
		model.setColumnCount(colCount);
		model.setRowCount(sheet.getLastRowNum());
		System.out.println(sheet.getLastRowNum());
		for(int i=0;i<sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				Cell cell = row.getCell(j);
				model.setValueAt(cell.getStringCellValue().toString(), i, j);
			}
		}
		
	}
	//Đọc tên file
	public String ChooseFileOpen() {
        String path = null;
        JFileChooser chooser = new JFileChooser();
        int rVal = chooser.showOpenDialog(null);
        if ( rVal == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile().getName();
            String dir = chooser.getCurrentDirectory().toString();
            path = dir+"\\"+filename;
            System.out.println(path);
            return path;           
        } 
        else {
            return null;
        }   
    }
	//Lưu file Excel
    public String ChooseFileSave(){
         String path = null;
        JFileChooser chooser = new JFileChooser();
        int rVal = chooser.showSaveDialog(null);
        if ( rVal == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile().getName();
            String dir = chooser.getCurrentDirectory().toString();
            path = dir+"\\"+filename+ getCurrenDate()+ ".xlsx";
             System.out.println(path);
            return path;
        } else {
            return null;
        }   
    }
    
}
