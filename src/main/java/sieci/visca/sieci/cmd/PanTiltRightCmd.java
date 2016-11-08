package sieci.visca.sieci.cmd;

public final class PanTiltRightCmd extends Cmd
{
    private static final byte[] ptRightCommandData;
    
    static {
        ptRightCommandData = new byte[] { 1, 6, 1, 0, 0, 2, 3 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(PanTiltRightCmd.ptRightCommandData);
        cmdData[3] = 4;
        cmdData[4] = 1;
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
