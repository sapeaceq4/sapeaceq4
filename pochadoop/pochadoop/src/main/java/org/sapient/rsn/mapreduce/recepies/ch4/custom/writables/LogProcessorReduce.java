package org.sapient.rsn.mapreduce.recepies.ch4.custom.writables;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Created by rsi164 on 1/2/2017.
 */
public class LogProcessorReduce extends Reducer<Text, LogWritable, Text, IntWritable> {

}
