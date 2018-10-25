package ru.pavelm.javacoreadvanced;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void chars() {
        String letters = "rp cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c";
        char[] charArray ={ 'a', 'e', 'i', 'o', 'u', 'y' };
        char[] arc = letters.toCharArray();
        int count = 0;
        for (int i: arc) {
            for (int j: charArray) {
                if(i == j) {
                    count++;
                }
            }
        }
    }
}
