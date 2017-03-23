package org.sapient.rsn.mapreduce.samples.cdr;

/**
 * Created by rsi164 on 12/29/2016.
 */

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CDRMapReduceTest {

    private MapDriver<Object, Text, Text, LongWritable> mapDriver;

    private ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;

    private MapReduceDriver<Object, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;

    @Before
    public void setup() {
        CDRMapper cdrMapper = new CDRMapper();
        CDRReducer cdrReducer = new CDRReducer();
        mapDriver = MapDriver.newMapDriver(cdrMapper);
        reduceDriver = ReduceDriver.newReduceDriver(cdrReducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(cdrMapper, cdrReducer);
    }

    @Test
    public void cdrMapReduceWhenMapperShouldPass() throws IOException {
        mapDriver.withInput(new LongWritable(), new Text("9665128505|8983006310|2015-03-01 09:08:10|2015-03-01 10:12:15|1"));
        mapDriver.withOutput(new Text("9665128505"), new LongWritable(64));
        mapDriver.runTest();
    }

    @Test
    public void cdrMapReduceWhenReducerShouldPass() throws IOException {
        List<LongWritable> values = new ArrayList<>();
        values.add(new LongWritable(24));
        values.add(new LongWritable(41));
        values.add(new LongWritable(11));
        reduceDriver.withInput(new Text("9665128505"), values);
        reduceDriver.withOutput(new Text("9665128505"), new LongWritable(76));
        reduceDriver.runTest();
    }

    @Test
    public void cdrMapReduceWhenMapReduceShouldPass() throws IOException {
//        List<LongWritable> values = new ArrayList<>();
//        values.add(new LongWritable(24));
//        values.add(new LongWritable(41));
//        values.add(new LongWritable(11));
        mapReduceDriver.withInput(new LongWritable(), new Text("9665128505|8983006310|2015-03-01 09:08:10|2015-03-01 10:12:15|1" ));
        mapReduceDriver.withOutput( new Text("9665128505"), new LongWritable(64));
        mapReduceDriver.runTest();
    }
}
