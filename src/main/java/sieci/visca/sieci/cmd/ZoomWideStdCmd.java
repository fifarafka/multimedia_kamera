package sieci.visca.sieci.cmd;

public final class ZoomWideStdCmd extends Cmd
{
    private static final byte[] ptWideStdCommandData;
    
    static {
        ptWideStdCommandData = new byte[] { 1, 4, 7, 3 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(ZoomWideStdCmd.ptWideStdCommandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
