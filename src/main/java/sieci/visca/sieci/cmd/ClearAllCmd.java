package sieci.visca.sieci.cmd;

public final class ClearAllCmd extends Cmd
{
    private static final byte[] clearAllCommandData;
    
    static {
        clearAllCommandData = new byte[] { 1, 0, 1 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(ClearAllCmd.clearAllCommandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
