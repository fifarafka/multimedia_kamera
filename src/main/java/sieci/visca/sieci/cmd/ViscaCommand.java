package sieci.visca.sieci.cmd;

public class ViscaCommand
{
    public byte sourceAdr;
    public byte destinationAdr;
    public byte[] commandData;
    
    public byte[] getCommandData() {
        final int cmdLen = this.commandData.length + 1 + 1;
        final byte[] cmdData = new byte[cmdLen];
        final byte head = (byte)(0x80 | (this.sourceAdr & 0x7) << 4 | (this.destinationAdr & 0xF));
        final byte tail = -1;
        System.arraycopy(this.commandData, 0, cmdData, 1, this.commandData.length);
        cmdData[0] = head;
        cmdData[cmdData.length - 1] = tail;
        return cmdData;
    }
}
