package sieci.visca.sieci.cmd;


public final class PanTiltHomeCmd extends Cmd
{
    private static final byte[] ptHomeCommandData;
    
    static {
        ptHomeCommandData = new byte[] { 1, 6, 4 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(PanTiltHomeCmd.ptHomeCommandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
