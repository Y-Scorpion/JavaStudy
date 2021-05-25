package 第一课;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * java基本属性
 */
public class DataType {
    static Logger logger = LogManager.getLogger(TestLog.class);
    private char aChar ; //字符类型
    private byte aByte ; //数字类型 byte
    private short aShort; //数字类型 short
    private int aInt;   //数字类型 int
    private long aLong; //长数字类型 long
    private float aFloat; //单精度数字类型 float
    private double aDouble; // 双精度类型 double
    private boolean aBoolean; //布尔类型 boolean

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public byte getaByte() {
        return aByte;
    }

    public void setaByte(byte aByte) {
        this.aByte = aByte;
    }

    public short getaShort() {
        return aShort;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public int getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public String toString() {
        return "dataType{" +
                "aChar=" + aChar +
                ", aByte=" + aByte +
                ", aShort=" + aShort +
                ", aInt=" + aInt +
                ", aLong=" + aLong +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", aBoolean=" + aBoolean +
                '}';
    }
    /**
     * java 八大基本类型测试输出
     * @param args
     */
    public static void main(String[] args) {
        DataType dataType = new DataType();
        dataType.setaChar('a');
        dataType.setaByte((byte) 20);
        dataType.setaShort((short) 100);
        dataType.setaInt(2000);
        dataType.setaLong(1000L);
        dataType.setaFloat(100.1f);
        dataType.setaDouble(100.11);
        dataType.setaDouble(1);
        logger.info(dataType);
    }
}
