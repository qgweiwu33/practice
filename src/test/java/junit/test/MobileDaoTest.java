package junit.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qg.bean.Mobile;
import com.qg.dao.MobileDao;

public class MobileDaoTest {

	@Test
	public void test11() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		MobileDao dao = context.getBean(MobileDao.class);

		dao.saveMobile(new Mobile(1, 10086, "背景", "中国联动", 1000, 2000));
		System.out.println("OK");
	}

	@Test
	public void test112() throws EncryptedDocumentException, InvalidFormatException, IOException {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		MobileDao dao = context.getBean(MobileDao.class);

		// 1、指定要读取EXCEL文档名称
		String filename = "d://chart/Mobile.xls";
		// 2、创建输入流
		FileInputStream input = new FileInputStream(filename);
		// 3、通过工作簿工厂类来创建工作簿对象
		Workbook workbook = WorkbookFactory.create(input);
		int sheetnum = workbook.getNumberOfSheets();
//		System.out.println(sheetnum);
		for (int a = 0; a < sheetnum; a++) {
			// 判断该表有多少行
			Sheet sheet = workbook.getSheetAt(a);
//			Sheet sheet=workbook.getSheet("Sheet1");
			int rownum = sheet.getPhysicalNumberOfRows();
//			System.out.println(rownum);
			for (int i = 1; i < rownum; i++) {
				Row row = sheet.getRow(i);
				// 判断该行有几个单元格
				int cellnum = row.getPhysicalNumberOfCells();
//				System.out.println(cellnum);
				StringBuffer b = new StringBuffer();
				for (int j = 0; j < cellnum; j++) {
					Cell cell = row.getCell(j);
					if (cell.getCellTypeEnum() == CellType.STRING) {
						b.append(cell.getStringCellValue() + "~");
					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						// 创建数字格式化工具
						DecimalFormat df = new DecimalFormat("####");
						b.append(df.format(cell.getNumericCellValue()) + "~");
					}
				}

				// 分析一行的内容
				String hang = b.toString();
				String[] rows = hang.split("~");
				Mobile m = new Mobile(Integer.parseInt(rows[0]), Integer.parseInt(rows[1]), rows[2], rows[3],
						Integer.parseInt(rows[4]), Integer.parseInt(rows[5]));

				// 保存学生信息到数据库
				dao.saveMobile(m);
			}
		}
		workbook.close();

	}
	
	@Test
	public void test113() throws EncryptedDocumentException, InvalidFormatException, IOException{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		MobileDao dao = context.getBean(MobileDao.class);

		// 1、指定要读取EXCEL文档名称
		String filename = "d://chart/Mobile.xls";
		// 2、创建输入流
		FileInputStream input = new FileInputStream(filename);
		// 3、通过工作簿工厂类来创建工作簿对象
		Workbook workbook = WorkbookFactory.create(input);
		List<Mobile> list=new ArrayList<>();
//		int sheetnum = workbook.getNumberOfSheets();
	
			// 判断该表有多少行
			Sheet sheet = workbook.getSheet("Sheet1");
			int rownum = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < 1000; i++) {
				Row row = sheet.getRow(i);
				// 判断该行有几个单元格
				int cellnum = row.getPhysicalNumberOfCells();
				StringBuffer b = new StringBuffer();
				for (int j = 0; j < cellnum; j++) {
					Cell cell = row.getCell(j);
					if (cell.getCellTypeEnum() == CellType.STRING) {
						b.append(cell.getStringCellValue() + "~");
					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						// 创建数字格式化工具
						DecimalFormat df = new DecimalFormat("####");
						b.append(df.format(cell.getNumericCellValue()) + "~");
					}
				}

				// 分析一行的内容
				String hang = b.toString();
				String[] rows = hang.split("~");
				Mobile m = new Mobile(Integer.parseInt(rows[0]), Integer.parseInt(rows[1]), rows[2], rows[3],
						Integer.parseInt(rows[4]), Integer.parseInt(rows[5]));
				list.add(m);
				// 保存学生信息到数据库
//				dao.saveMobile(m);
			}
		dao.saveMobileBatch(list);
		workbook.close();

	}

}
