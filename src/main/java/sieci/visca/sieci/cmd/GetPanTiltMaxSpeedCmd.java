package sieci.visca.sieci.cmd;

public final class GetPanTiltMaxSpeedCmd extends Cmd
{
    private static final byte[] maxSpeedCommandData;
    
    static {
        maxSpeedCommandData = new byte[] { 9, 6, 17 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(GetPanTiltMaxSpeedCmd.maxSpeedCommandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
