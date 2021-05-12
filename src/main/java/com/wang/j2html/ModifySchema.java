package com.wang.j2html;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ModifySchema {
    public static void main(String[] args) {
     /*   modifyRegexp("11A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})$");
        modifyRegexp("12A","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<InstrumentCodeorDescription>[${x}]{1,30})$");
        modifyRegexp("12B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<InstrumentTypeCode>[${c}]{4}$)");
        modifyRegexp("12C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CFICode>[${c}]{6})$");
        modifyRegexp("13A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NumberId>[${c}]{3})$");
        modifyRegexp("13B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<Number>[${x}]{1,30})$");
        modifyRegexp("13J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<ExtendedNumberId>[${c}]{5})$");
        modifyRegexp("13K","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NumberId>[${c}]{3})\\/(?<Quantity>${d})$");
       // modifyRegexp("16R","");
      //  modifyRegexp("16S","");
        modifyRegexp("17B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Flag>[${a}]{1})$");
        modifyRegexp("19A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("19B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
       // modifyRegexp("20","");
        modifyRegexp("20C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Reference>[${x}]{1,16})$");
        modifyRegexp("20D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Reference>[${x}]{1,25})$");
        modifyRegexp("20U","^:(?<Qualifier>[${c}]{4})\\/\\/(?<UTIReference>[${x}]{1,52})$");
      //  modifyRegexp("21","");
        modifyRegexp("22F","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<Indicator>[${c}]{4})$");
        modifyRegexp("22H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Indicator>[${c}]{4})$");
      //  modifyRegexp("23","");
        modifyRegexp("23G","^(?<Function>[${c}]{4})(?<Subfunction>(\\/[${c}]{4})?)$");
        modifyRegexp("24B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<ReasonCode>[${c}]{4}$)");
        modifyRegexp("25D","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<StatusCode>[${c}]{4})$");
       // modifyRegexp("26H","");
        modifyRegexp("28E","^(?<PageNumber>[${n}]{1,5})\\/(?<ContinuationIndicator>[${c}]{4})$");
        modifyRegexp("29A","^(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("29B","^(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("30","^(?<Date>[${n}]{6})$");
        modifyRegexp("31F","^(?<Date>[${n}]{6})(?<PeriodDate>(\\/[${n}]{6})?)(?<PeriodDetails>(\\/\\/[${x}]{1,35})?)$");
        modifyRegexp("31L","^(?<Date>[${n}]{6})$");
        modifyRegexp("31P","^(?<Date>[${n}]{6})(?<Place>([${x}]{1,29})?)$");
        modifyRegexp("31X","^((?<Date>[${n}]{6})((?<Time>[${n}]{4}))?)?(?<Code>([${a}]{7})?)$");
        modifyRegexp("32A","^(?<Date>[${n}]{6})(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("32B","^(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("33S","^(?<Code>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("33T","^(?<Currency>[${a}]{3})(?<Price>${d})$");
        modifyRegexp("34B","^(?<Currency>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("35A","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35B","^(?<IdentificationofSecurity>(ISIN [${c}]{12})?)(?<crlf>(\\r\\n)?)(?<DescriptionofSecurity>(([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})?)$");
        modifyRegexp("35H","^(?<Sign>[N]?)(?<Currency>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35N","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("35S","^(?<Type>[${a}]{3})(?<Quantity>${d})$");
        modifyRegexp("36B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Quantity>${d})$");
        modifyRegexp("36C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityCode>[${c}]{4})$");
        modifyRegexp("36E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Sign>[N]?)(?<Quantity>${d})$");
        modifyRegexp("37A","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37B","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37C","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37D","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37E","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37F","^(?<Rate>${d})(\\/\\/(?<EndDate>[${n}]{6})(?<Period>[${a}]{1})(?<Number>[${n}]{1,3}))?(\\/(?<Information>[${x}]{1,16}))?$");
        modifyRegexp("37J","^(?<Rate>${d})$");
        modifyRegexp("57A","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("57B","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<Location>(([${x}]{1,35}){1})?)$");
        modifyRegexp("57D","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<NameandAddress>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("69A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date1>[${n}]{8})\\/(?<Date2>[${n}]{8})$");
        modifyRegexp("69B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date1>[${n}]{8})(?<Time1>[${n}]{6})\\/(?<Date2>[${n}]{8})(?<Time2>[${n}]{6})$");
        modifyRegexp("69C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("69D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("69E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})\\/(?<Date>[${n}]{8})$");
        modifyRegexp("69F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})$");
        modifyRegexp("69J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("70C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("70D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("70E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,9}([${x}]{1,35}){1})$");
        modifyRegexp("70F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>[${z}]{1,8000})$");
        modifyRegexp("70G","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>([${x}]{1,35}\\r\\n){0,9}([${z}]{1,35}){1})$");
        modifyRegexp("70H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Narrative>[${z}]{1,2500})$");
        modifyRegexp("72","^(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("77D","^(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("80C","^(?<Narrative>([${x}]{1,35}\\r\\n){0,5}([${x}]{1,35}){1})$");
        modifyRegexp("83C","^(?<Account>\\/[${x}]{1,34})$");
        modifyRegexp("87A","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("87D","^(?<PartyIdentifier>(\\/[${a}]{1})?(\\/[${x}]{1,34})?)(?<crlf>(\\r\\n)?)(?<NameandAddress>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("90A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<PercentageTypeCode>[${c}]{4})\\/(?<Sign>[N]?)(?<Price>${d})$");
        modifyRegexp("90B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<AmountTypeCode>[${c}]{4})\\/(?<CurrencyCode>[${a}]{3})(?<Price>${d})$");
        modifyRegexp("90E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<PriceCode>[${c}]{4})$");
        modifyRegexp("90F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<AmountTypeCode>[${c}]{4})\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Quantity>${d})$");
        modifyRegexp("90J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<AmountTypeCode>[${c}]{4})\\/(?<CurrencyCode1>[${a}]{3})(?<Amount1>${d})\\/(?<CurrencyCode2>[${a}]{3})(?<Amount2>${d})$");
        modifyRegexp("90K","^:(?<Qualifier>[${c}]{4})\\/\\/(?<IndexPoints>${d})$");
        modifyRegexp("90L","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<IndexPoints>${d})$");
        modifyRegexp("92A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<Rate>${d})$");
        modifyRegexp("92B","^:(?<Qualifier>[${c}]{4})\\/(?<FirstCurrencyCode>[${a}]{3})\\/(?<SecondCurrencyCode>[${a}]{3})\\/(?<Rate>${d})$");
        modifyRegexp("92C","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<RateName>[${x}]{1,24})$");
        modifyRegexp("92D","^:(?<Qualifier>[${c}]{4})\\/(?<Quantity1>${d})\\/(?<Quantity2>${d})$");
        modifyRegexp("92F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("92H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})\\/(?<RateStatus>[${c}]{4})$");
        modifyRegexp("92J","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<RateTypeCode>[${c}]{4})\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})(?<RateStatus>(\\/[${c}]{4})?)$");
        modifyRegexp("92K","^:(?<Qualifier>[${c}]{4})\\/\\/(?<RateTypeCode>[${c}]{4})$");
        modifyRegexp("92L","^:(?<Qualifier>[${c}]{4})\\/\\/(?<FirstCurrencyCode>[${a}]{3})(?<Amount1>${d})\\/(?<SecondCurrencyCode>[${a}]{3})(?<Amount2>${d})$");
        modifyRegexp("92M","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})\\/(?<Quantity>${d})$");
        modifyRegexp("92N","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Quantity>${d})\\/(?<CurrencyCode>[${a}]{3})(?<Amount>${d})$");
        modifyRegexp("92P","^:(?<Qualifier>[${c}]{4})\\/\\/(?<IndexPoints>${d})$");
        modifyRegexp("92R","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<RateTypeCode>[${c}]{4})\\/(?<Rate>${d})$");
        modifyRegexp("93A","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<SubbalanceType>[${c}]{4})$");
        modifyRegexp("93B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<Sign>[N]?)(?<Balance>${d})$");
        modifyRegexp("93C","^:(?<Qualifier>[${c}]{4})\\/(?<QuantityTypeCode>[${c}]{4})\\/(?<BalanceTypeCode>[${c}]{4})\\/(?<Sign>[N]?)(?<Balance>${d})$");
        modifyRegexp("93D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<Balance>${d})$");
        modifyRegexp("94B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{0,8})?)\\/(?<PlaceCode>[${c}]{4})(?<Narrative>(\\/[${x}]{1,30})?)$");
        modifyRegexp("94C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CountryCode>[${a}]{2})$");
        modifyRegexp("94D","^:(?<Qualifier>[${c}]{4})\\/\\/(?<CountryCode>([${a}]{2})?)\\/(?<Place>[${x}]{1,35})$");
        modifyRegexp("94E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Address>([${x}]{1,35}\\r\\n){0,9}([${x}]{1,35}){1})$");
        modifyRegexp("94F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<PlaceCode>[${c}]{4})\\/(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("94G","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Address>([${x}]{1,35}\\r\\n){0,1}([${x}]{1,35}){1})$");
        modifyRegexp("94H","^:(?<Qualifier>[${c}]{4})\\/\\/(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("94L","^:(?<Qualifier>[${c}]{4})\\/\\/(?<LegalEntityIdentifier>[${c}]{18}[${c}]{2})$");
        modifyRegexp("95C","^:(?<Qualifier>[${c}]{4})//(?<CountryCode>[${a}]{2})$");
        modifyRegexp("95L","^:(?<Qualifier>[${c}]{4})\\/\\/(?<LegalEntityIdentifier>[${c}]{18}[${n}]{2})$");
        modifyRegexp("95P","^:(?<Qualifier>[${c}]{4})\\/\\/(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("95Q","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NameandAddress>([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})$");
        modifyRegexp("95R","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>[${c}]{1,8})\\/(?<ProprietaryCode>[${x}]{1,34})$");
        modifyRegexp("95S","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<TypeofID>[${c}]{4})\\/(?<CountryCode>[${a}]{2})\\/(?<AlternateID>[${x}]{1,30})$");
        modifyRegexp("95U","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Name>([${x}]{1,35}\\r\\n){0,2}([${x}]{1,35}){1})$");
        modifyRegexp("95V","^:(?<Qualifier>[${c}]{4})\\/\\/(?<NameandAddress>([${x}]{1,35}\\r\\n){0,9}([${x}]{1,35}){1})$");
        modifyRegexp("97A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<AccountNumber>[${x}]{1,35})$");
        modifyRegexp("97B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<AccountTypeCode>[${c}]{4})\\/(?<AccountNumber>[${x}]{1,35})$");
        modifyRegexp("97C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<AccountCode>[${c}]{4})$");
        modifyRegexp("97E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<InternationalBankAccountNumber>[${x}]{1,34})$");
        modifyRegexp("98A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})$");
        modifyRegexp("98B","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>([${c}]{1,8})?)\\/(?<DateCode>[${c}]{4})$");
        modifyRegexp("98C","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})$");
        modifyRegexp("98E","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})(?<Decimals>(,[${n}]{1,3})?)(?<UTCIndicator>(/[N]?[${n}]{2}([${n}]{2})?)?)$");
        modifyRegexp("98F","^:(?<Qualifier>[${c}]{4})\\/\\/(?<DataSourceScheme>([${c}]{8})?)\\/(?<DateCode>[${c}]{4})(?<Time>[${n}]{6})$");
        modifyRegexp("98J","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})\\/(?<IdentifierCode>[${a}]{4}[${a}]{2}[${c}]{2}([${c}]{3})?)$");
        modifyRegexp("98K","^:(?<Qualifier>[${c}]{4})\\/(?<DataSourceScheme>[${c}]{1,8})\\/(?<Date>[${n}]{8})(?<Time>[${n}]{6})\\/(?<ProprietaryCode>[${x}]{1,34})$");
        modifyRegexp("99A","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Sign>[N]?)(?<Number>[${n}]{3})$");
        modifyRegexp("99B","^:(?<Qualifier>[${c}]{4})\\/\\/(?<Number>[${n}]{3})$"); */
        Map<String,String> map = new HashMap<>();

      /*  map.put("1","Qualifier");
        map.put("3","CurrencyCode");
        addContentName("11A",map,4);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","InstrumentCodeorDescription");
        addContentName("12A",map,6);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","InstrumentTypeCode");
        addContentName("12B",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","CFICode");
        addContentName("12C",map,4);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","NumberId");
        addContentName("13A",map,4);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","Number");
        addContentName("13B",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","ExtendedNumberId");
        addContentName("13J",map,4);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","NumberId");
        map.put("5","Quantity");
        addContentName("13K",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","Flag");
        addContentName("17B",map,4);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","Sign");
        map.put("4","CurrencyCode");
        map.put("5","Amount");
        addContentName("19A",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("4","CurrencyCode");
        map.put("5","Amount");
        addContentName("19B",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","Reference");
        addContentName("20C",map,4);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","Reference");
        addContentName("20D",map,4);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","UTIReference");
        addContentName("20U",map,4);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","Indicator");
        addContentName("22F",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","Indicator");
        addContentName("22H",map,4);
        map.clear();

        map.put("0","Function");
        map.put("1","Subfunction");
        addContentName("23G",map,2);
        map.clear();


        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","ReasonCode");
        addContentName("24B",map,6);
        map.clear();

        map.put("1","Qualifier");
        map.put("3","DataSourceScheme");
        map.put("5","StatusCode");
        addContentName("25D",map,6);
        map.clear();

    */

        map.put("0","PageNumber");
        map.put("2","ContinuationIndicator");
        addContentName("28E",map,3);
        map.clear();


        map.put("0","Narrative");
        addContentName("29A",map,1);
        map.clear();

        map.put("0","Narrative");
        addContentName("29B",map,1);
        map.clear();

        map.put("0","Date");
        addContentName("30",map,1);
        map.clear();


        map.put("0","Date");
        map.put("1","PeriodDate");
        map.put("2","PeriodDetails");
        addContentName("31F",map,3);
        map.clear();


        map.put("0","Date");
        addContentName("31L",map,1);
        map.clear();


        map.put("0","Date");
        map.put("1","Place");
        addContentName("31P",map,2);
        map.clear();



        map.put("1","Qualifier");
        addContentName("36B",map,2);
        addContentName("36C",map,2);
        addContentName("36E",map,2);
        addContentName("69B",map,2);
        addContentName("69C",map,2);
        addContentName("69D",map,2);
        addContentName("69E",map,2);
        addContentName("69F",map,2);
        addContentName("69J",map,2);
        addContentName("70C",map,2);
        addContentName("70D",map,2);
        addContentName("70E",map,2);
        addContentName("70F",map,2);
        addContentName("70G",map,2);
        addContentName("70H",map,2);
        addContentName("90A",map,2);
        addContentName("90B",map,2);
        addContentName("90E",map,2);
        addContentName("90F",map,2);
        addContentName("90J",map,2);
        addContentName("90K",map,2);
        addContentName("90L",map,2);
        addContentName("92A",map,2);
        addContentName("92B",map,2);
        addContentName("92C",map,2);
        addContentName("92D",map,2);
        addContentName("92F",map,2);
        addContentName("92H",map,2);
        addContentName("92J",map,2);
        addContentName("92K",map,2);
        addContentName("92L",map,2);
        addContentName("92M",map,2);
        addContentName("92N",map,2);
        addContentName("92P",map,2);
        addContentName("92R",map,2);
        addContentName("93A",map,2);
        addContentName("93B",map,2);
        addContentName("93C",map,2);
        addContentName("93D",map,2);
        addContentName("94B",map,2);
        addContentName("94C",map,2);
        addContentName("94D",map,2);
        addContentName("94E",map,2);
        addContentName("94F",map,2);
        addContentName("94G",map,2);
        addContentName("94H",map,2);
        addContentName("94L",map,2);
        addContentName("95C",map,2);
        addContentName("95L",map,2);
        addContentName("95P",map,2);
        addContentName("95Q",map,2);
        addContentName("95R",map,2);
        addContentName("95S",map,2);
        addContentName("95U",map,2);
        addContentName("95V",map,2);
        addContentName("97A",map,2);
        addContentName("97B",map,2);
        addContentName("97C",map,2);
        addContentName("97E",map,2);
        addContentName("98A",map,2);
        addContentName("98B",map,2);
        addContentName("98C",map,2);
        addContentName("98E",map,2);
        addContentName("98F",map,2);
        addContentName("98J",map,2);
        addContentName("98K",map,2);
        addContentName("99A",map,2);
        addContentName("99B",map,2);
        map.clear();
    }

    public static  void modifyRegexp(String tagName ,String newRegexp){
        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='"+tagName+"']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String oldRegexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp",newRegexp);
                        System.out.println(tagName+":"+oldRegexp);
                        System.out.println(tagName+":"+newRegexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
    }

    public  static  void  addContentName(String tagName ,Map<String,String> contentNameMap,int normalContentCount){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='"+tagName+"']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                       List<Element> elementList = tagElement.selectNodes("content");
                    /*   if(elementList.size()!=normalContentCount){
                           System.out.println(fileName+"的"+tagName+"格式不统一，未更改");
                           continue;
                       }*/
                        Set<Map.Entry<String,String>> entrySet = contentNameMap.entrySet();
                        for(Iterator<Map.Entry<String,String>> iterator = entrySet.iterator();iterator.hasNext();){
                            Map.Entry<String,String> entry = iterator.next();
                            String contentName_No = entry.getKey();
                            String contentName  = entry.getValue();
                            elementList.get(Integer.parseInt(contentName_No)).addAttribute("contentName",contentName);
                        }

                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }


    }

    public static void  modify92J(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92J']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}\\/[${a}]{3}${d}(\\/[${c}]{4})?$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify92C(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92C']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${x}]{1,24}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify25D(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='25D']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
    public static void  modify99A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='99A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("format",":4!c//[N]3!n");
                        System.out.println(tagName+":"+format);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95S(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95S']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}\\/[${a}]{2}\\/[${x}]{1,30}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify92A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='92A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[N]?${d}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify19A(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='19A']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        String format = tagElement.attributeValue("format");
                        tagElement.addAttribute("format",":4!c//[N]3!a15d");
                        System.out.println(tagName+":"+format);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify99B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='99B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[${n}]{3}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify98B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='98B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/([${c}]{1,8})?\\/[${c}]{4}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify35B(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='35B']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        tagElement.addAttribute("regexp","^(ISIN [${c}]{12})?\\r\\n(([${x}]{1,35}\\r\\n){0,3}([${x}]{1,35}){1})?$");

                        List<Element> contentList  = tagElement.selectNodes("./content[last()]");

                        Element contenntELement = contentList.get(0);
                        String contentTypt = contenntELement.attributeValue("type");
                        if("textarea".equals(contentTypt)){
                            contenntELement.addAttribute("prefix","lf");
                        }

                        List<Element> firstContentList  = tagElement.selectNodes("./content[position()=1]");
                        Element firstContentELement = firstContentList.get(0);
                        String  firstContentLength = firstContentELement.attributeValue("fixedlength");
                        System.out.println(firstContentLength);
                        firstContentELement.addAttribute("fixedlength","17");
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95L(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95L']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}\\/\\/[${c}]{18}[${n}]{2}$");
                        System.out.println(tagName+":"+regexp);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }

    public static void  modify95C(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='95C']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");

                        tagElement.addAttribute("regexp","^:[${c}]{4}//[${a}]{2}$");
                        System.out.println(tagName+":"+regexp);
                    }

                   XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
    public static void  modify16R16SFormat(){

        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir,"/src/main/resources/schema");
        System.out.println(userDir);
        System.out.println(filePath);
        File schemaDirectory  = new File(filePath.toString());
        if(schemaDirectory.isDirectory()){
            File[] files = schemaDirectory.listFiles();
            for (File file:files){
                String fileName = file.getName();
                System.out.println(fileName);
                if(file.isFile()&&fileName.endsWith(".xml")&&fileName.startsWith("MT5")){

                    SAXReader saxReader  = new SAXReader();
                    Document document = null;
                    try {
                        document = saxReader.read(file);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }

                    Element root = document.getRootElement();
                    List<Element> tagList = root.selectNodes("//Tag[@name='16R']|//Tag[@name='16S']");
                    if(tagList.isEmpty()){
                        continue;
                    }
                    for (int i = 0; i < tagList.size(); i++) {
                        Element tagElement = tagList.get(i);
                        String tagName = tagElement.attributeValue("name");
                        String regexp = tagElement.attributeValue("regexp");
                        tagElement.addAttribute("format","16c");
                        //System.out.println(tagName);
                    }

                    XMLWriter writer = null;
                    try {
                        writer = new XMLWriter(new FileOutputStream(file));
                        writer.write(document);
                        writer.close();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

    }
}
