package com.mooip.code.projectEuler;

import java.lang.reflect.Field;
import java.math.BigInteger;

/**
 * Large sum.
 * <p>
 * While the problem wants the first 10 digits, this gives out the whole sum.  I had fun with this by 
 * using reflection to add all the BigIntegers below.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=13">Large sum</a>
 */
public final class Problem13 {
    private static final BigInteger bi1 = new BigInteger("37107287533902102798797998220837590246510135740250");
    private static final BigInteger bi2 = new BigInteger("46376937677490009712648124896970078050417018260538");
    private static final BigInteger bi3 = new BigInteger("74324986199524741059474233309513058123726617309629");
    private static final BigInteger bi4 = new BigInteger("91942213363574161572522430563301811072406154908250");
    private static final BigInteger bi5 = new BigInteger("23067588207539346171171980310421047513778063246676");
    private static final BigInteger bi6 = new BigInteger("89261670696623633820136378418383684178734361726757");
    private static final BigInteger bi7 = new BigInteger("28112879812849979408065481931592621691275889832738");
    private static final BigInteger bi8 = new BigInteger("44274228917432520321923589422876796487670272189318");
    private static final BigInteger bi9 = new BigInteger("47451445736001306439091167216856844588711603153276");
    private static final BigInteger bi10 = new BigInteger("70386486105843025439939619828917593665686757934951");
    private static final BigInteger bi11 = new BigInteger("62176457141856560629502157223196586755079324193331");
    private static final BigInteger bi12 = new BigInteger("64906352462741904929101432445813822663347944758178");
    private static final BigInteger bi13 = new BigInteger("92575867718337217661963751590579239728245598838407");
    private static final BigInteger bi14 = new BigInteger("58203565325359399008402633568948830189458628227828");
    private static final BigInteger bi15 = new BigInteger("80181199384826282014278194139940567587151170094390");
    private static final BigInteger bi16 = new BigInteger("35398664372827112653829987240784473053190104293586");
    private static final BigInteger bi17 = new BigInteger("86515506006295864861532075273371959191420517255829");
    private static final BigInteger bi18 = new BigInteger("71693888707715466499115593487603532921714970056938");
    private static final BigInteger bi19 = new BigInteger("54370070576826684624621495650076471787294438377604");
    private static final BigInteger bi20 = new BigInteger("53282654108756828443191190634694037855217779295145");
    private static final BigInteger bi21 = new BigInteger("36123272525000296071075082563815656710885258350721");
    private static final BigInteger bi22 = new BigInteger("45876576172410976447339110607218265236877223636045");
    private static final BigInteger bi23 = new BigInteger("17423706905851860660448207621209813287860733969412");
    private static final BigInteger bi24 = new BigInteger("81142660418086830619328460811191061556940512689692");
    private static final BigInteger bi25 = new BigInteger("51934325451728388641918047049293215058642563049483");
    private static final BigInteger bi26 = new BigInteger("62467221648435076201727918039944693004732956340691");
    private static final BigInteger bi27 = new BigInteger("15732444386908125794514089057706229429197107928209");
    private static final BigInteger bi28 = new BigInteger("55037687525678773091862540744969844508330393682126");
    private static final BigInteger bi29 = new BigInteger("18336384825330154686196124348767681297534375946515");
    private static final BigInteger bi30 = new BigInteger("80386287592878490201521685554828717201219257766954");
    private static final BigInteger bi31 = new BigInteger("78182833757993103614740356856449095527097864797581");
    private static final BigInteger bi32 = new BigInteger("16726320100436897842553539920931837441497806860984");
    private static final BigInteger bi33 = new BigInteger("48403098129077791799088218795327364475675590848030");
    private static final BigInteger bi34 = new BigInteger("87086987551392711854517078544161852424320693150332");
    private static final BigInteger bi35 = new BigInteger("59959406895756536782107074926966537676326235447210");
    private static final BigInteger bi36 = new BigInteger("69793950679652694742597709739166693763042633987085");
    private static final BigInteger bi37 = new BigInteger("41052684708299085211399427365734116182760315001271");
    private static final BigInteger bi38 = new BigInteger("65378607361501080857009149939512557028198746004375");
    private static final BigInteger bi39 = new BigInteger("35829035317434717326932123578154982629742552737307");
    private static final BigInteger bi40 = new BigInteger("94953759765105305946966067683156574377167401875275");
    private static final BigInteger bi41 = new BigInteger("88902802571733229619176668713819931811048770190271");
    private static final BigInteger bi42 = new BigInteger("25267680276078003013678680992525463401061632866526");
    private static final BigInteger bi43 = new BigInteger("36270218540497705585629946580636237993140746255962");
    private static final BigInteger bi44 = new BigInteger("24074486908231174977792365466257246923322810917141");
    private static final BigInteger bi45 = new BigInteger("91430288197103288597806669760892938638285025333403");
    private static final BigInteger bi46 = new BigInteger("34413065578016127815921815005561868836468420090470");
    private static final BigInteger bi47 = new BigInteger("23053081172816430487623791969842487255036638784583");
    private static final BigInteger bi48 = new BigInteger("11487696932154902810424020138335124462181441773470");
    private static final BigInteger bi49 = new BigInteger("63783299490636259666498587618221225225512486764533");
    private static final BigInteger bi50 = new BigInteger("67720186971698544312419572409913959008952310058822");
    private static final BigInteger bi51 = new BigInteger("95548255300263520781532296796249481641953868218774");
    private static final BigInteger bi52 = new BigInteger("76085327132285723110424803456124867697064507995236");
    private static final BigInteger bi53 = new BigInteger("37774242535411291684276865538926205024910326572967");
    private static final BigInteger bi54 = new BigInteger("23701913275725675285653248258265463092207058596522");
    private static final BigInteger bi55 = new BigInteger("29798860272258331913126375147341994889534765745501");
    private static final BigInteger bi56 = new BigInteger("18495701454879288984856827726077713721403798879715");
    private static final BigInteger bi57 = new BigInteger("38298203783031473527721580348144513491373226651381");
    private static final BigInteger bi58 = new BigInteger("34829543829199918180278916522431027392251122869539");
    private static final BigInteger bi59 = new BigInteger("40957953066405232632538044100059654939159879593635");
    private static final BigInteger bi60 = new BigInteger("29746152185502371307642255121183693803580388584903");
    private static final BigInteger bi61 = new BigInteger("41698116222072977186158236678424689157993532961922");
    private static final BigInteger bi62 = new BigInteger("62467957194401269043877107275048102390895523597457");
    private static final BigInteger bi63 = new BigInteger("23189706772547915061505504953922979530901129967519");
    private static final BigInteger bi64 = new BigInteger("86188088225875314529584099251203829009407770775672");
    private static final BigInteger bi65 = new BigInteger("11306739708304724483816533873502340845647058077308");
    private static final BigInteger bi66 = new BigInteger("82959174767140363198008187129011875491310547126581");
    private static final BigInteger bi67 = new BigInteger("97623331044818386269515456334926366572897563400500");
    private static final BigInteger bi68 = new BigInteger("42846280183517070527831839425882145521227251250327");
    private static final BigInteger bi69 = new BigInteger("55121603546981200581762165212827652751691296897789");
    private static final BigInteger bi70 = new BigInteger("32238195734329339946437501907836945765883352399886");
    private static final BigInteger bi71 = new BigInteger("75506164965184775180738168837861091527357929701337");
    private static final BigInteger bi72 = new BigInteger("62177842752192623401942399639168044983993173312731");
    private static final BigInteger bi73 = new BigInteger("32924185707147349566916674687634660915035914677504");
    private static final BigInteger bi74 = new BigInteger("99518671430235219628894890102423325116913619626622");
    private static final BigInteger bi75 = new BigInteger("73267460800591547471830798392868535206946944540724");
    private static final BigInteger bi76 = new BigInteger("76841822524674417161514036427982273348055556214818");
    private static final BigInteger bi77 = new BigInteger("97142617910342598647204516893989422179826088076852");
    private static final BigInteger bi78 = new BigInteger("87783646182799346313767754307809363333018982642090");
    private static final BigInteger bi79 = new BigInteger("10848802521674670883215120185883543223812876952786");
    private static final BigInteger bi80 = new BigInteger("71329612474782464538636993009049310363619763878039");
    private static final BigInteger bi81 = new BigInteger("62184073572399794223406235393808339651327408011116");
    private static final BigInteger bi82 = new BigInteger("66627891981488087797941876876144230030984490851411");
    private static final BigInteger bi83 = new BigInteger("60661826293682836764744779239180335110989069790714");
    private static final BigInteger bi84 = new BigInteger("85786944089552990653640447425576083659976645795096");
    private static final BigInteger bi85 = new BigInteger("66024396409905389607120198219976047599490197230297");
    private static final BigInteger bi86 = new BigInteger("64913982680032973156037120041377903785566085089252");
    private static final BigInteger bi87 = new BigInteger("16730939319872750275468906903707539413042652315011");
    private static final BigInteger bi88 = new BigInteger("94809377245048795150954100921645863754710598436791");
    private static final BigInteger bi89 = new BigInteger("78639167021187492431995700641917969777599028300699");
    private static final BigInteger bi90 = new BigInteger("15368713711936614952811305876380278410754449733078");
    private static final BigInteger bi91 = new BigInteger("40789923115535562561142322423255033685442488917353");
    private static final BigInteger bi92 = new BigInteger("44889911501440648020369068063960672322193204149535");
    private static final BigInteger bi93 = new BigInteger("41503128880339536053299340368006977710650566631954");
    private static final BigInteger bi94 = new BigInteger("81234880673210146739058568557934581403627822703280");
    private static final BigInteger bi95 = new BigInteger("82616570773948327592232845941706525094512325230608");
    private static final BigInteger bi96 = new BigInteger("22918802058777319719839450180888072429661980811197");
    private static final BigInteger bi97 = new BigInteger("77158542502016545090413245809786882778948721859617");
    private static final BigInteger bi98 = new BigInteger("72107838435069186155435662884062257473692284509516");
    private static final BigInteger bi99 = new BigInteger("20849603980134001723930671666823555245252804609722");
    private static final BigInteger bi100 = new BigInteger("53503534226472524250874054075591789781264330331690");
    
    public Problem13() {
    }

    //answer is 5537376230
    public static String problem13() {
        BigInteger bigSum = new BigInteger("0");
        
        for (int i = 1; i <= 100; i++) {
            final String fieldName = "bi" + i;
            try {
                final Field field = Problem13.class.getDeclaredField(fieldName);
                final BigInteger big = (BigInteger) field.get(fieldName);
                bigSum = bigSum.add(big);
            } catch (NoSuchFieldException nfee) {
                throw new RuntimeException("field: " + fieldName + " does not exist! " + nfee);
            } catch (IllegalAccessException eee) {
                throw new RuntimeException(eee);
            }
        }
        
        return bigSum.toString();
    }
    
    public static void main(String[] args){
        System.out.println(problem13());
    }   
}

