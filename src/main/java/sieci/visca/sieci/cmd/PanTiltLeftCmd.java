package sieci.visca.sieci.cmd;

public final class PanTiltLeftCmd extends Cmd
{
    private static final byte[] ptLeftCommandData;
    
    static {
        ptLeftCommandData = new byte[] { 1, 6, 1, 0, 0, 1, 3 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(PanTiltLeftCmd.ptLeftCommandData);
        cmdData[3] = 8;
        cmdData[4] = 1;
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
