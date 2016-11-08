package sieci.visca.sieci.cmd;

public final class ZoomTeleStdCmd extends Cmd
{
    private static final byte[] ptTeleStdCommandData;
    
    static {
        ptTeleStdCommandData = new byte[] { 1, 4, 7, 2 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(ZoomTeleStdCmd.ptTeleStdCommandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
