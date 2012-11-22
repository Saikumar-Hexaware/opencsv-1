# Overview
The stock version of OpenCSV lacks a feature to bind to a domain model by column name regardless of order.
My implementation extends the ```HeaderColumnNameMappingStrategy``` class to enable mapping of columns
in any order i.e. you don't have to worry about the position of the column. You can define the columns to be read
in mixed manner and it will just map them correctly.

## Example
Create an instance of ```OrderLessHeaderColumnNameMappingStrategy```

```
OrderLessHeaderColumnNameMappingStrategy orderLessHeaderImpl = new OrderLessHeaderColumnNameMappingStrategy();
```

Create a ```Array``` of columns you need to read from a CSV file

```
// Create an array of column names to be read
String[] columnsToMap = new String[] {"fname", "telephone", "id"};
```

Set columns you want to read in the ```orderLessHeaderImpl``` instance

```
// Set the columns to be mapped
orderLessHeaderImpl.setColumnsToMap(columnsToMap);
```

You're all set. Now, execute the below code to read and parse your CSV file.

```
CsvToBean csvToBean = new CsvToBean();
List<Person> list = null;

CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("test.csv")));
list = csvToBean.parse(orderLessHeaderImpl, reader);

for(Person person : list) {
    System.out.println(person);
}
```

## Questions or Issues
Open an issue please.