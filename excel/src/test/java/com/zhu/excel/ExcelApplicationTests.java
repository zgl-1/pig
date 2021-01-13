package com.zhu.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zhu.excel.pojo.DemoData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.cellwalk.CellWalk;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ExcelApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test03() throws Exception {
		Workbook workbook = new HSSFWorkbook();
		Sheet mysheet = workbook.createSheet("mysheet");
		Row row = mysheet.createRow(0);
		Cell cell1 = row.createCell(0);
		cell1.setCellValue("hello");
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("hello");

		FileOutputStream fileOutputStream = new FileOutputStream("E:\\code\\pig" + "\\test.xls");
		workbook.write(fileOutputStream);

		fileOutputStream.close();
	}

	@Test
	void test07() throws Exception {
		Workbook workbook = new XSSFWorkbook();
		Sheet mysheet = workbook.createSheet("mysheet");
		Row row = mysheet.createRow(0);
		Cell cell1 = row.createCell(0);
		cell1.setCellValue("hello");
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("hello");

		FileOutputStream fileOutputStream = new FileOutputStream("E:\\code\\pig" + "\\test.xlsx");
		workbook.write(fileOutputStream);

		fileOutputStream.close();
	}

	@Test
	void test031() throws Exception {
		Long start = System.currentTimeMillis();

		Workbook workbook = new HSSFWorkbook();
		Sheet mysheet = workbook.createSheet("mysheet");
		for (int i = 0; i < 65536; i++) {
			Row row = mysheet.createRow(i);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue("hello");
			Cell cell2 = row.createCell(1);
			cell2.setCellValue("hello");
		}

		FileOutputStream fileOutputStream = new FileOutputStream("E:\\code\\pig" + "\\test.xls");
		workbook.write(fileOutputStream);

		fileOutputStream.close();

		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	@Test
	void test071() throws Exception {
		Long start = System.currentTimeMillis();
		Workbook workbook = new XSSFWorkbook();
		Sheet mysheet = workbook.createSheet("mysheet");
		for (int i = 0; i < 100000; i++) {
			Row row = mysheet.createRow(i);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue("hello");
			Cell cell2 = row.createCell(1);
			cell2.setCellValue("hello");
		}

		FileOutputStream fileOutputStream = new FileOutputStream("E:\\code\\pig" + "\\test.xlsx");
		workbook.write(fileOutputStream);

		fileOutputStream.close();
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	@Test
	void test0711() throws Exception {
		Long start = System.currentTimeMillis();
		Workbook workbook = new SXSSFWorkbook();
		Sheet mysheet = workbook.createSheet("mysheet");
		for (int i = 0; i < 100000; i++) {
			Row row = mysheet.createRow(i);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue("hello");
			Cell cell2 = row.createCell(1);
			cell2.setCellValue("hello");
		}

		FileOutputStream fileOutputStream = new FileOutputStream("E:\\code\\pig" + "\\test.xlsx");
		workbook.write(fileOutputStream);

		fileOutputStream.close();

		//清楚临时文件
		((SXSSFWorkbook) workbook).dispose();

		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	@Test
	void testRead03() throws Exception {
		FileInputStream fileInputStream=new FileInputStream("E:\\code\\pig\\test.xls");

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		//String stringCellValue = cell.getStringCellValue();
		/*if(cell.getCellType()== CellType.FORMULA){
			FormulaEvaluator  formulaEvaluator=new HSSFFormulaEvaluator(workbook);
			CellValue evaluate = formulaEvaluator.evaluate(cell);
			System.out.println(evaluate.getNumberValue());
		}*/
		//System.out.println(stringCellValue);

		fileInputStream.close();

	}

	@Test
	void testRead07() throws Exception {
		FileInputStream fileInputStream=new FileInputStream("E:\\code\\pig\\test.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);

		fileInputStream.close();

	}

	/**
	 * 最简单的写
	 * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
	 * <p>2. 直接写即可
	 */
	@Test
	public void simpleWrite() {
		// 写法1
		String fileName = "E:\\code\\pig\\" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		// 如果这里想使用03 则 传入excelType参数即可
		EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

		// 写法2
		/*fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去写
		ExcelWriter excelWriter = null;
		try {
			excelWriter = EasyExcel.write(fileName, DemoData.class).build();
			WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
			excelWriter.write(data(), writeSheet);
		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}*/
	}
	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<DemoData>();
		for (int i = 0; i < 10; i++) {
			DemoData data = new DemoData();
			data.setString("字符串" + i);
			data.setDate(new Date());
			data.setDoubleData(0.56);
			list.add(data);
		}
		return list;
	}
}
