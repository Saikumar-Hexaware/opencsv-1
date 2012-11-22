# Overview
The stock version of OpenCSV lacks a feature to bind to a domain model by column name regardless of order.
My implementation extends the ```HeaderColumnNameMappingStrategy``` class to enable mapping of columns
in any order i.e. you don't have to worry about the order of the column. You can define the columns to be read
in mixed manner and it will just map them correctly.

## Example
Create an instance of ```OrderLessHeaderColumnNameMappingStrategy```

```
OrderLessHeaderColumnNameMappingStrategy orderLessHeaderImpl = new OrderLessHeaderColumnNameMappingStrategy();
```

Create a ```HashMap``` of columns you need to read from a CSV file

```
// Key is the column name and Value is the column position in the header.
// Value is determined automatically by OrderLessHeaderColumnNameMappingStrategy.
HashMap<String, Integer> columnsToMap = new HashMap<String, Integer>();

// Initially we put values as null. Order doesn't matter.
columnsToMap.put("fname", null);
columnsToMap.put("telephone", null);
columnsToMap.put("id", null);
```

Set columns you want to read in the ```orderLessHeaderImpl``` instance

```
// Set the columns to be mapped
orderLessHeaderImpl.setHeaderToMap(columnsToMap);
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