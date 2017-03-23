package org.sapient.rsn.mapreduce.recepies.ch4.custom.writables;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by rsi164 on 1/2/2017.
 */

public class LogWriteComparable implements WritableComparable<LogWriteComparable> {

    private Text userIP, timestamp, request;
    private IntWritable responseSize, status;

    public LogWriteComparable(Text userIP, Text timestamp, Text request, IntWritable responseSize, IntWritable status) {
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

    @Override
    public int compareTo(LogWriteComparable o) {
        if (userIP.compareTo(o.userIP)==0){
                return (timestamp.compareTo(o.timestamp));
        }else return (userIP.compareTo(o.userIP));

    }

    @Override
    public int hashCode() {
        return userIP.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LogWritable) {
            LogWriteComparable other = (LogWriteComparable) o;
            return userIP.equals(other.userIP)
                    && timestamp.equals(other.timestamp);
        }
        return false;
    }
}
