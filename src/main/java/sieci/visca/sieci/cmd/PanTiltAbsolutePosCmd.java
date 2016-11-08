package sieci.visca.sieci.cmd;

public final class PanTiltAbsolutePosCmd extends Cmd
{
    private static final byte[] ptAbsolutPosCommandData;
    
    static {
        final byte[] ptAbsolutPosCommandData2 = new byte[14];
        ptAbsolutPosCommandData2[0] = 1;
        ptAbsolutPosCommandData2[1] = 6;
        ptAbsolutPosCommandData2[2] = 2;
        ptAbsolutPosCommandData = ptAbsolutPosCommandData2;
    }
    
    @Override
    public byte[] createCommandData() {
        final byte[] cmdData = duplicatArray(PanTiltAbsolutePosCmd.ptAbsolutPosCommandData);
        cmdData[3] = 1;
        cmdData[5] = 0;
        cmdData[6] = 3;
        cmdData[7] = 7;
        cmdData[8] = 5;
        cmdData[9] = 0;
        return cmdData;
    }
    
    private static byte[] duplicatArray(final byte[] src) {
        final byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
}
