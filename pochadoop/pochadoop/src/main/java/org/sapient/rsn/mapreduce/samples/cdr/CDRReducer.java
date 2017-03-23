package org.sapient.rsn.mapreduce.samples.cdr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


/**
 * Created by rsi164 on 12/28/2016.
 */
public class CDRReducer  extends
        Reducer< Text , LongWritable, Text, LongWritable> {
    private LongWritable result = new LongWritable();

    public void reduce(Text key, Iterable< LongWritable> values,
                       Reducer< Text , LongWritable, Text, LongWritable>.Context context)
            throws IOException, InterruptedException {
        long sum = 0;
        for (LongWritable val : values) {
            sum += val.get();
        }
        this.result.set(sum);
        if (sum >= 60) {
            context.write(key, this.result);
        }

    }
}