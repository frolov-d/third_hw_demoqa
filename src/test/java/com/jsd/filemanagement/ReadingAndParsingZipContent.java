package com.jsd.filemanagement;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingAndParsingZipContent {

    private ClassLoader cl = ReadingAndParsingZipContent.class.getClassLoader();

    @Test
    void testPdf() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testdata/zipped.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".pdf")) {
                    PDF pdf = new PDF(zs);
                    assertEquals(19, pdf.numberOfPages);
                    assertEquals(25844, pdf.text.length());
                    assertTrue(pdf.text.startsWith("Как составить"));
                    return;
                }
                entry = zs.getNextEntry();
            }
            fail("No PDF file found in zip archive");
        }
    }

    @Test
    void testXls() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testdata/zipped.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".xls")) {
                    XLS xls = new XLS(zs);
                    assertEquals(1000, xls.excel.getSheetAt(0).getLastRowNum());
                    assertEquals("First Name", xls.excel.getSheetAt(0).getRow(0).getCell(1).toString());
                    assertEquals("Last Name", xls.excel.getSheetAt(0).getRow(0).getCell(2).toString());
                    assertEquals("Gender", xls.excel.getSheetAt(0).getRow(0).getCell(3).toString());
                    return;
                }
                entry = zs.getNextEntry();
            }
            fail("No XLS file found in zip archive");
        }
    }

    @Test
    void testCsv() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testdata/zipped.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".csv")) {
                    InputStreamReader isr = new InputStreamReader(zs);
                    CSVReader csvReader = new CSVReader(isr);
                    List<String[]> content = csvReader.readAll();
                    assertEquals(7, content.size());
                    assertArrayEquals(new String[]{"Username; Identifier;First name;Last name"}, content.get(0));
                    return;
                }
                entry = zs.getNextEntry();
            }
            fail("No CSV file found in zip archive");
        }
    }
}