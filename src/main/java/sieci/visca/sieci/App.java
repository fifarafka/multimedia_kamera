package sieci.visca.sieci;

import java.util.Scanner;

import jssc.SerialPort;
import jssc.SerialPortException;
import sieci.visca.sieci.cmd.AddressCmd;
import sieci.visca.sieci.cmd.PanTiltDownCmd;
import sieci.visca.sieci.cmd.PanTiltLeftCmd;
import sieci.visca.sieci.cmd.PanTiltRightCmd;
import sieci.visca.sieci.cmd.PanTiltUpCmd;
import sieci.visca.sieci.cmd.ViscaCommand;
import sieci.visca.sieci.ViscaResponseReader;

/**
 * Hello world!
 *
 */

public class App 
{
	
	private static Scanner sc;

	static void turnRight(SerialPort port) throws SerialPortException {
		System.out.println("Right");
        sendPanTiltRight(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
        sendPanTiltRight2(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
	}
	
	static void turnLeft(SerialPort port) throws SerialPortException {
		System.out.println("Left");
        sendPanTiltLeft(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
        sendPanTiltLeft2(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
	}
	
	static void turnUp(SerialPort port) throws SerialPortException {
		System.out.println("Up");
        sendPanTiltUp(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
	}
	
	static void turnDown(SerialPort port) throws SerialPortException {
		System.out.println("Down");
        sendPanTiltDown(port);
        try {
            final byte[] response = ViscaResponseReader.readResponse(port);
            System.out.println("> " + byteArrayToString(response));
        }
        catch (ViscaResponseReader.TimeoutException ex2) {
            System.out.println("! TIMEOUT exception");
        }
	}
	
	public static void main(final String[] args) {
        final String com = args[0];
        final SerialPort port = new SerialPort(com);
        try {
            port.openPort();
            port.setParams(9600, 8, 1, 0);
            System.out.println("Address");
            sendAddress(port);
            try {
                final byte[] response = ViscaResponseReader.readResponse(port);
                System.out.println("> " + byteArrayToString(response));
            }
            catch (ViscaResponseReader.TimeoutException ex2) {
                System.out.println("! TIMEOUT exception");
            }
            sleep(5);
            System.out.println("Choose what you want to do: ");
            System.out.println("1 - Right");
            System.out.println("2 - Left");
            System.out.println("3 - Down");
            System.out.println("4 - Up");
            while (true) {
            	sc = new Scanner(System.in);
            	String line2 = sc.nextLine();
            	if (line2.equals("1")) {
            		turnRight(port);
            	}
            	if (line2.equals("2")) {
            		turnLeft(port);
            	}
            	if (line2.equals("3")) {
            		turnDown(port);
            	}
            	if (line2.equals("4")) {
            		turnUp(port);
            	}
            }
        }
        catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
    
    private static void sleep(final int timeSec) {
        try {
            Thread.sleep(timeSec * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static void sendPanTiltLeft(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltLeftCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendPanTiltLeft2(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltLeftCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 2;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendPanTiltRight(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltRightCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendPanTiltRight2(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltRightCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 2;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendPanTiltUp(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltUpCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendPanTiltDown(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new PanTiltDownCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static void sendAddress(final SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = new AddressCmd().createCommandData();
        final ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 8;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
    
    private static String byteArrayToString(final byte[] bytes) {
        final StringBuilder sb = new StringBuilder();
        for (final byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}
