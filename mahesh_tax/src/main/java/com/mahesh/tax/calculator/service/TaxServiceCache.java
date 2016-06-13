/**
 * 
 */
package com.mahesh.tax.calculator.service;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.FastHashMap;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.mahesh.tax.calculator.domain.Item;
import com.mahesh.tax.calculator.domain.TaxEntry;

/**
 * @author maheshd
 *
 */
public class TaxServiceCache
{
	private static FastHashMap cachedTaxEntryMapping = new FastHashMap();

	public static Double getSalesTaxRate(Item item)
	{

		TaxEntry taxEntry= (TaxEntry) cachedTaxEntryMapping.get(item.getName());
		return taxEntry.getSalesTax();
	}

	public static Double getImportDutyRate(Item item)
	{
		TaxEntry taxEntry= (TaxEntry) cachedTaxEntryMapping.get(item.getName());
		return taxEntry.getImportDuty();
	}

	public static void addTaxChartToCache() 
	{
		List<TaxEntry> taxChartCsvData = csvToTaxChartData();
		for (TaxEntry taxEntry : taxChartCsvData)
		{
			if (!cachedTaxEntryMapping.containsKey(taxEntry.getItemName()))
			{
				cachedTaxEntryMapping.put(taxEntry.getItemName(), taxEntry);
			}
		}
	}

	private static List<TaxEntry> csvToTaxChartData()
	{
		CsvToBean<TaxEntry> csvBean = new CsvToBean<TaxEntry>();
		List<TaxEntry> taxChartCsvData = new ArrayList<TaxEntry>();
		ColumnPositionMappingStrategy<TaxEntry> csvReaderColumnMappingStrategy = new ColumnPositionMappingStrategy<TaxEntry>();
		final String[] columns = new String[] { "category", "salesTax", "importDuty", "itemName" };
		CSVReader csvReader = null;
		try
		{
			URL url=TaxServiceCache.class.getResource("/Tax_Chart.csv");
			File file = new File(url.toURI());
			csvReader = new CSVReader(new FileReader(file), ',', '"', 1);
			csvReaderColumnMappingStrategy.setColumnMapping(columns);
			csvReaderColumnMappingStrategy.setType(TaxEntry.class);
			taxChartCsvData = csvBean.parse(csvReaderColumnMappingStrategy, csvReader);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			IOUtils.closeQuietly(csvReader);
		}
		return taxChartCsvData;
	}
}
