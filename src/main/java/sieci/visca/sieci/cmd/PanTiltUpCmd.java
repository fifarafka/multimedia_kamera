package sieci.visca.sieci.cmd;

public final class PanTiltUpCmd extends Cmd
{
    private static final byte[] ptUpCommandData;
    
    static {
        ptUpCommandData = new byte[] { 1, 6, 1, 0, 0, 3, 1 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(PanTiltUpCmd.ptUpCommandData);
        cmdData[3] = 1;
        cmdData[4] = 2;
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
