package sieci.visca.sieci.cmd;


public final class AddressCmd extends Cmd
{
    private static final byte[] adrCommmandData;
    
    static {
        adrCommmandData = new byte[] { 48, 1 };
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(AddressCmd.adrCommmandData);
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}