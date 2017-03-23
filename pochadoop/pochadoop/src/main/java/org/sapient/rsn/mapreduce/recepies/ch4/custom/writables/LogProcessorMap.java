package org.sapient.rsn.mapreduce.recepies.ch4.custom.writables;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by rsi164 on 1/2/2017.
 */
public class LogProcessorMap extends Mapper<LongWritable,Text,Text,LogWritable> {


}
