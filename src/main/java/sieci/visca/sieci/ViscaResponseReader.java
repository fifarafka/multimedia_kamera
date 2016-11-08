package sieci.visca.sieci;

import java.util.ArrayList;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ViscaResponseReader {
private static final long TIMEOUT_MS = 5000L;
    
    public static byte[] readResponse(final SerialPort serialPort) throws TimeoutException, SerialPortException {
        final ArrayList<Byte> data = new ArrayList<Byte>();
        final long startTime = System.currentTimeMillis();
        while (true) {
            if (serialPort.getInputBufferBytesCount() == 0) {
                final long currentTime = System.currentTimeMillis();
                final long timeDiff = currentTime - startTime;
                if (timeDiff > 5000L) {
                    throw new TimeoutException();
                }
                continue;
            }
            else {
                final byte[] bs = serialPort.readBytes(1);
                final byte b = bs[0];
                data.add(b);
                if (b == -1) {
                    final byte[] responseData = new byte[data.size()];
                    int idx = 0;
                    for (final Byte b2 : data) {
                        responseData[idx++] = b2;
                    }
                    return responseData;
                }
                continue;
            }
        }
    }
    
    public static class TimeoutException extends Exception
    {
        public TimeoutException() {
        }
        
        public TimeoutException(final String message, final Throwable cause) {
            super(message, cause);
        }
        
        public TimeoutException(final String message) {
            super(message);
        }
    }
}
