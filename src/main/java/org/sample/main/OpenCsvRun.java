package org.sample.main;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.OrderLessHeaderColumnNameMappingStrategy;
import org.sample.domain.Person;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jatinder Singh on 2012-11-21 at 10:06 PM
 */
public class OpenCsvRun {
    public static void main(String[] args) {
        OrderLessHeaderColumnNameMappingStrategy orderLessHeaderImpl = new OrderLessHeaderColumnNameMappingStrategy();

        // Map rows in CSV file to Person bean
        orderLessHeaderImpl.setType(Person.class);

        // Create an array of column names to be read
        String[] columnsToMap = new String[] {"fname", "telephone", "id"};

        // Set the columns to be mapped
        orderLessHeaderImpl.setColumnsToMap(columnsToMap);

        CsvToBean csvToBean = new CsvToBean();
        List<Person> list = null;

        CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("test.csv")));
        list = csvToBean.parse(orderLessHeaderImpl, reader);

        for(Person person : list) {
            System.out.println(person);
        }
    }
}
