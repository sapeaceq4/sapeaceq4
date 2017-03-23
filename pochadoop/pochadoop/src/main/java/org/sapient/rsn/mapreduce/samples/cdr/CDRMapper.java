package org.sapient.rsn.mapreduce.samples.cdr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rsi164 on 12/28/2016.
 */
public class CDRMapper extends Mapper<Object, Text, Text, LongWritable> {

    private Text phoneNumber = new Text();
    private LongWritable durationInMinutes = new LongWritable();

    public void map(Object key, Text value,
                    Mapper<Object, Text, Text, LongWritable>.Context context)
            throws IOException, InterruptedException {
        String[] parts = value.toString().split("[|]");
        if (parts[CDRConstants.STDFlag].equalsIgnoreCase("1")) {

            phoneNumber.set(parts[CDRConstants.fromPhoneNumber]);
            String callEndTime = parts[CDRConstants.callEndTime];
            String callStartTime = parts[CDRConstants.callStartTime];
            long duration = toMillis(callEndTime) - toMillis(callStartTime);
            durationInMinutes.set(duration / (1000 * 60));
            context.write(phoneNumber, durationInMinutes);
        }
    }

    private long toMillis(String date) {

        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date dateFrm = null;
        try {
            dateFrm = format.parse(date);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return dateFrm.getTime();
    }
}