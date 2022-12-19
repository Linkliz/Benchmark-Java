package com.example.demo;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DecryptDataTest {

    @Benchmark
    @Timeout(time = 60)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode({Mode.Throughput})
    public void dataWithDecrypt() throws IOException{
        URL url = new URL("http://localhost:8000/api/v1/distribution-router/v1/demo/service-remove-header/10");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("channel", "D2B");
        httpConn.setRequestProperty("transaction-code", "2500");
        httpConn.setRequestProperty("Content-Type", "application/json");

        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("{\n    \"data\": {\n        \"transactionInformation\": {\n            \"date\": \"20220121\",\n            \"time\": \"120501123\",\n            \"channel\": \"APP\",\n            \"trace\": \"#(deliveryAdapter)\",\n            \"CID\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAABN9zM0N22JdkRp1kr2Y8xULI6/bWAlnUiBTellhS4vWVuVuXsvXriQ1WDvq+gM4VcQVXQnxeJ43rBOloXJ\"\n        },\n        \"originCustomerInformation\": {\n            \"identification\": {\n                \"type\": \"TIPDOC_FS001\",\n                \"number\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAADOpq9VfTvIDsdAlv4RdogI8JubZsfPB6vMutWXJ0amVTA+xQ==\"\n            }\n        }\n    }\n}");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);
    }

//    @Benchmark
//    @Fork(value = 1,warmups = 1)
//    @Timeout(time = 60)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @BenchmarkMode({Mode.Throughput})
//    public void dataWithDecryptAndNotKms() throws IOException{
//        URL url = new URL("http://localhost:8000/api/v1/distribution-router/v1/demo/service-remove-header/10");
//        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        httpConn.setRequestMethod("POST");
//
//        httpConn.setRequestProperty("channel", "D2B");
//        httpConn.setRequestProperty("transaction-code", "2500");
//        httpConn.setRequestProperty("Content-Type", "application/json");
//
//        httpConn.setDoOutput(true);
//        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
//        writer.write("{\n    \"data\": {\n        \"transactionInformation\": {\n            \"date\": \"20220121\",\n            \"time\": \"120501123\",\n            \"channel\": \"APP\",\n            \"trace\": \"#(deliveryAdapter)\",\n            \"CID\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAABN9zM0N22JdkRp1kr2Y8xULI6/bWAlnUiBTellhS4vWVuVuXsvXriQ1WDvq+gM4VcQVXQnxeJ43rBOloXJ\"\n        },\n        \"originCustomerInformation\": {\n            \"identification\": {\n                \"type\": \"TIPDOC_FS001\",\n                \"number\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAADOpq9VfTvIDsdAlv4RdogI8JubZsfPB6vMutWXJ0amVTA+xQ==\"\n            }\n        }\n    }\n}");
//        writer.flush();
//        writer.close();
//        httpConn.getOutputStream().close();
//
//        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
//                ? httpConn.getInputStream()
//                : httpConn.getErrorStream();
//        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
//        String response = s.hasNext() ? s.next() : "";
//        System.out.println(response);
//    }

    @Benchmark
    @Timeout(time = 60)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode({Mode.Throughput})
    public void dataWithNotDecrypt() throws IOException{
        URL url = new URL("http://localhost:8000/api/v1/distribution-router/v1/demo/service-remove-header/10");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("channel", "D2B");
        httpConn.setRequestProperty("transaction-code", "2600");
        httpConn.setRequestProperty("Content-Type", "application/json");

        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("{\n    \"data\": {\n        \"transactionInformation\": {\n            \"date\": \"20220121\",\n            \"time\": \"120501123\",\n            \"channel\": \"APP\",\n            \"trace\": \"#(deliveryAdapter)\",\n            \"CID\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAABN9zM0N22JdkRp1kr2Y8xULI6/bWAlnUiBTellhS4vWVuVuXsvXriQ1WDvq+gM4VcQVXQnxeJ43rBOloXJ\"\n        },\n        \"originCustomerInformation\": {\n            \"identification\": {\n                \"type\": \"TIPDOC_FS001\",\n                \"number\": \"S2Fybjphd3M6a21zOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6a2V5LzQxYWRlNWU3LTBjZjktNGU2MC1hYWI4LWZmOGFmMzM1ODE0MAAAAADOpq9VfTvIDsdAlv4RdogI8JubZsfPB6vMutWXJ0amVTA+xQ==\"\n            }\n        }\n    }\n}");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);
    }
}
