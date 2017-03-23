package org.sapient.rsn.mapreduce.recepies.ch4.custom.writables;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by rsi164 on 1/2/2017.
 */

public class LogWritable implements Writable {

    private Text userIP, timestamp, request;
    private IntWritable responseSize, status;

    public LogWritable(Text userIP, Text timestamp, Text request, IntWritable responseSize, IntWritable status) {
        this.userIP = userIP;
        this.timestamp = timestamp;
        this.request = request;
        this.responseSize = responseSize;
        this.status = status;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        userIP.write(out);
        timestamp.write(out);
        request.write(out);
        responseSize.write(out);
        status.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        userIP.readFields(in);
        timestamp.readFields(in);
        request.readFields(in);
        responseSize.readFields(in);
        status.readFields(in);
    }


    public Text getUserIP() {
        return userIP;
    }

    public void setUserIP(Text userIP) {
        this.userIP = userIP;
    }

    public Text getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Text timestamp) {
        this.timestamp = timestamp;
    }

    public Text getRequest() {
        return request;
    }

    public void setRequest(Text request) {
        this.request = request;
    }

    public IntWritable getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(IntWritable responseSize) {
        this.responseSize = responseSize;
    }

    public IntWritable getStatus() {
        return status;
    }

    public void setStatus(IntWritable status) {
        this.status = status;
    }
}
