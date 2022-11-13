package org.sample.algorithms.strings;

import org.junit.jupiter.api.Assertions;

public class Palindrome {
    static boolean isPalindrome(String palStr){
        if (palStr == null || palStr.isEmpty()) {
            return false;
        }
        String cleanReg = "[^a-zA-Z0-9]";
        palStr = palStr.replaceAll(cleanReg, "").toLowerCase();
        String [] chars = palStr.split("");
        int left = 0, right = palStr.length() -1;
        for (int i = left; i < right; i++) {
            if (chars[left].equalsIgnoreCase(chars[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean isValidSubPalindrome (String [] chars, int left, int right) {
        while (left < right) {
            if (!chars[left].equalsIgnoreCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // this approach feels much less modular. The basic idea here is once its not-equal once, just skip and remaining and see if its still palindrome
    // the skip once and do same looks static. what if I have to skip twice ? have another for loop
    static boolean isAlmostPalindrome (String palStr) {
        if (palStr == null) {
            return false;
        }
        if (palStr.length()<=2) {
            return true;
        }

        String cleanReg = "[^a-zA-Z0-9]";
        palStr = palStr.replaceAll(cleanReg, "").toLowerCase();
        String [] chars = palStr.split("");
        int left =0, right = chars.length -1;

        while (left < right) {
            if (!chars[left].equalsIgnoreCase(chars[right])) {
                return isValidSubPalindrome(chars, left+1, right) || isValidSubPalindrome(chars, left, right-1);
            }
            left ++;
            right --;
        }

        return true;
    }


    static boolean isValidPalindrome(String palStr) {
        if (palStr == null) return false;
        if (palStr.isEmpty()) return true;

        int left = 0, right = palStr.length() - 1;
        String [] chars = palStr.split("");

        for (; left < right ; left++, right--) {
            if (chars[left].equalsIgnoreCase(chars[right])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static String longestPalindrome(String palStr) {
        if (palStr == null) return null;
        if (palStr.length() <= 1) return "";

        String cleanReg = "[^a-zA-Z0-9]";
        palStr = palStr.replaceAll(cleanReg, "").toLowerCase();

        int left = 0, right = palStr.length() - 1;
        int mid = (palStr.length()) / 2;

        while (left < right) {

            if (isValidPalindrome(palStr)) {
                return palStr;
            } else {
                String newRightSubStr = palStr.substring(left, right-1);
                String newLeftSubStr = palStr.substring(left+1, right);
                if (isValidPalindrome(newRightSubStr)) {
                    return newRightSubStr;
                } else if (isValidPalindrome(newLeftSubStr)){
                    return newLeftSubStr;
                }
            }

            left++;
            right--;
        }

        return "";
    }

    public static void main(String[] args) {
        //System.out.println(isPalindrome("ABCCba"));
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(isPalindrome("abccdba"));
        Assertions.assertTrue(isPalindrome("aba"));
        Assertions.assertFalse(isPalindrome("abca"));
        Assertions.assertFalse(isPalindrome("abc"));
        Assertions.assertFalse(isPalindrome("cbbcc"));
        Assertions.assertFalse(isPalindrome("abccdba"));

        Assertions.assertTrue(isAlmostPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertTrue(isAlmostPalindrome("aba"));
        Assertions.assertTrue(isAlmostPalindrome("abca"));
        Assertions.assertFalse(isAlmostPalindrome("abc"));
        Assertions.assertTrue(isAlmostPalindrome("cbbcc"));
        Assertions.assertFalse(isAlmostPalindrome("aabdeenddbaagbddeedbaa"));

        Assertions.assertTrue(isAlmostPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        Assertions.assertFalse(isAlmostPalindrome("klsaantowecjcflbenbvqbpcwqwdjqkoabnggutmufdoanehqjpuilhhkpwyoqfrirjnjaxfkhhvzcrfvttmplcmmaozoxtwyuiqfxciflbngmjrfrsvbjexknigqpydmirqwkajorlxmcrbpjpjsnqydekxzczshliuilwacdwvpgpurusvjxhjaesjrigrurkjmahpvvmmgindehhenslzdcjipydoiiiqhrrtlzfeajxwedhsjdsxsdzxcuxedluwulntgmqxknzoiwbgdyiofabdlceflnegqfuiogcfyptzbewwxohfefgrljvmeaottxsegrpvpugjxtzgpnqvlcnfvytwdhoulxoetbmxxvmsbuqnmvciovrsjvynfbgtkvzqiiawwnvjimwjwutotlqnnosgyugefihlvgktlgyhfwngpkvkrqxmbhlhoekvquajdhietjzphinpnahbbzyjrtprevbxgvesphvvokzjrxkdjksdjgfocyiulkvqxlnqdutehneuwfufiotgizpqncacynizdqqnirzhduivyroykiismqiyblivbwnaxdwxtavvfvaltjwftqnknvwcyycjrqndxykupjvydkiuzqqgilecayrfqmnhidiucutobazhxchydomjpuzgvtksxvlfgrwsajuyowiguxngvrdbujleraonwrxkdtpesxloyftsvksnpnprvkcicaywaltdpbxqgkyrfuhhpltvuitjawfftcflbwiwvxpmnpcsgzwqjqtrgkwuhzrezaplaigbmzyuxitotiqudspmsybhexqthqytbowqgwtsilejruirppswvfqlkxwtnujdblterntyqkmxqnzgxmkhdpkfxfjcyggrygpnszroqntdacbjdoluzvliowxwkkmnvvferkbfjoswnxvbakwbtgzbptweivqbomqmnkbukchrpipjfcagmiarfqtdpbjnwbysbcrxifwvvvlsbdspvoonzbpotjfjtvtakwbruzrqcbhuqpyjnhheovhmoemooincegopruvootaugneicjckjwfnufpxtuvitozhdycfbphoqghhdxfkbdcowbkfsoppzagjiawtmimcvvakhhvyjattapvgjdfmbceauowgazjrosruiytfokbnflozrxxecwggikblpvclgohtvhirllrndaujhookqbiihjpwdvsecowxyvghhiartoowvmxiqpojdreroisculxrqrnsymoummzcsudjvmgxzoljhpztqaufhmvjqmjbrbrcjvldnlvqzizfykqgkhjfnccnaegemejfmapfqwrknldyhuyuggozgbwzjrytooihldrgjrhgmihofvkpowucwzesiybxmblmmorhlfqonncczxofhpdkfucsmtffvgzhghugendcmluiyxsafzfycjfdqkutduxehrdwofpcqfshsgefrayoirjdixihdwojmaeezrdbydypqdqjxggiextuqrlegytrqpndxculxzsqrptqhwshcgokwlgmsykrthobxfppvuufbkpqsetkfxcafceibattvudyuysglkujfutidjthpzfbyurbesxdgmfukmqzapkrrybokwgfccmgsdmixsnfbyddcarlibxxoborenumzrwlptdrmryzvkftuyvqxymzyuidvhdfccfcghtvbmwuegixdvafuilphfypolbjlggdvutchurgzoqmoejewptgzdfkyscbzlpbijefbwwtbfyrjumrtaxrehwywrjgpgmcvyhzoqboamqisxotnoqcgomqutrrrrefazlalrltqmxiupixuqanjuocsujljkjxrmaktaxdbzqbecxcztxdegmbhqvdqxastttafeddoejctkafelwkworkeegpruajiwxfzjglqzcvcweiecvpizegmmvrobkbcaaytiompokjjbmcaayvwyircxrezfyinruddtfguxkbdytwzrfsjwqjvireabcebipchndsiqcmcknfwwxfsxgigjxlpxudktwwpadioldcgvfxyzsazuqasmwgzeusptcgzkynfcqcipbtygofhaiayvykvxrxcdauwvxrasvsrgxiutlholdiimldstptxkuwsugglxltpymyewxqbjthptjmbyjfzvkvhfhwfvcjfqxnaaskjktqyqgakoxthtwllqbnoctorsdlqxdszsyndrexzedwpcluoxvdyiktnwwjfksesqapymlputivtajodwcmcfixxkviikyhgnxfxszalbbbdsuqlurcymilntnuebfzaclodkalnkncduyekflyptqzfqmgeedaawlsjclvzkrwzjxvjuqmhidddudxhkefgvczajktofbetjlckgwtbwdkrngwjtbabyxzxrrzvgnpqehnrviqsqjhambgurksjftfpwaoomdfumxbkcdzzkkydcyltryyrzdfbkbubjjetcwztnhvegfynwqhkryowoxyfvbhirngmgjkkvdvfmugjefipofsmpahcukhwqxlrvaxzgcfqoiecvbyjujfskokxysycbprkazlznprlwnawgbftredntauaeigxiepdmasyzmhdjpztplaujnpckkwvvvckqcqqyxtyorkzenvnudnmoerpzyxrrutnrkaakhyflbwchrtbeajelcsqubtitpyzbitqxlmcssflyikzakmftwpazqycngpukzcmsskmvfrzjrbugoiotbgiwcecnwqgrtdlculhxupvyagqlqrkxmeroelglszpnjxgvkstrgbafuctyhralwipuyrsrtnsxzatmpccjpzhifbqfvrpptvhhwllmbcatphbgcwlgdtwnkunoklnyexeupwhhcqpoucxajlcvgslacieevbpjxomwknuyhzjfrrolyvhyowwxrhhknngmyayafbjparzfcuranjnoarzgjipptifslyqwssbbjvqfnmqhyfvreerphilrdzrwwuiecniqrqpgvfvtirkkzbgkxqdjxnufaerhfvptscbvbqczifuzdgccmddrzeluythrfobstzsjmgqziixfhatwbqpsysrcmawzzjgxrrpawelcoxdpbmjnkwzhdqrfotbivmakpbyvccjzzxagquxczpwmordemlgigclfwrchrmqhajldfldkfzfbngoysltapsjbtvzbjdjzpdjwoautkjozjkzlestuplaeicpblgclntixfnyuwthrjglatacmxhyuwfuranfabmlahumvsjrmnkiijtgxxrnjutthoxucppvvolmktclvkcykoncmptuzfteimkhopxqshlnkxejifbtflrqvrvkjrnwpyjftkymhrozvttxvhecbchkqtllkmeysjnvltzswgsoewmsdxwkpdtrmbzkrynqpirzywjoplfcnzolxzeqqrsaesmcdsitipxfknvngxbyrwvgcbiyfsxpyoqjkkjmxwcsbrgxreizgbuspqzgalmzcbvincbqywnqzerxtlpuawijjgxrtkmlpehvxxzniwrjejjqfedjjtoqahmnohtuhfutzcamcasilftltznjzthglqeuctqsvifqonctznsjawmnllcbuezogwqqrzafpadevlispmiotdorftyccygfackncscxhratqkacvhhkfjiypbtjbyavfiljglnxxigrtzmymdltshczrjohnraujzisfpnvvuoqlnkdujwcfrgbkqlqnppbwikxwresqkyxsweragiyixpcpvvjtnhezsiykxxlmikizqjkaewzjweoewsavfdyikgxttgnhgsnkgkspxccpblxtjouiadwnbbseavcamrdsjwiezubjsxrezgogfhyjukfnpjztbnsvtfheggyhlcgxpaddaqsutkdljkwkaaafxtvzoivhocktqmofzrhafxqoblhhjrpbcnyzsdkvkcmsoxazafosesjlnjyoettdwnmqkxdcimcbldmmqzspxhifojxjleairjcteaddonsfwcyhbfcyqxyicpnhahorooqoldioqpjbfcuaqqrrocfuwfbjuemqyqvpzuunprtiwdamuhkyybkiiuoojifadslwdhpzbunsfqxizizmdvakibucdxotvnwjgccjasfrriaxrqzmvkojpoqifohhlzrkxvhfebvordbxcpxrpdfybmmatctdsrqrlqzftbwjvenuhxhaifwoemophxqlmkhhtzbndjaplsjuqcalzawyequpslwmyubmwgwndiweplgeqitrhxztkbymcvtosuyvoxlmifinztgnuumbaspfwdozuvgowmtcxupbndgqxikphfddgpzunlmgtjjbcifbesbixapmgzzibvaiblhygmegcjbidgzkmiyugkjiyhguvxlkubbvkcndlelbwvhlibqcshaouwzqhgrlxlrtkutvjidblhelmoefqxtkurynagvktphmfleumxshgpmebvncvwroqvnbftioebhkbhbeuojblcwgfnfjfihlyxirslpjxpeggsruoexjljkgoshcuwfpuicemrpsdfvvkgncybiuinxdsbiezinaelixxrlyttrgyeatbtrhlxxraspltulbgqiydvpffhcnsusdukwtdsesamgkefppswjfmhgfgqarzptcuifepeafqzpdtbumnicborftrtzavajljcofrcdewcrqaviunzlgwzxpetxbnfsecqtokfmwmamluxddgyksxejxpuytbpfdyjyltidnobxhwoojdaxmmlkiodgpddtojnszzuhevdhwnliyiemkpgkasnlmlgqqfsxpdixpsqfgwhwaepbbztkybcnmrokccdysncdktjkxdoiscpawlanilxcgukkusvydbxoyvfwuxicwnksxffndtewxigzzgixwetdnffxsknwcixuwfvyoxbdyvsaukkugcxlinalwapcsiodxkjtkdcnsydcckormncbyktzbbpeawhwgfqspxidpxsfqqglmlnsakgpkmeiyilnwhdvehuzzsnjotddpgdoiklmmxadjoowhxbonditlyjydfpbtyupxjexskygddxulmamwmfkotqcesfnbxtepxzwglznuivaqrcwedcrfocjljavaztrtfrobcinmubtdpzqfaepefiuctpzraqgfghmfjwsppfekgmasesdtwkudsusnchffpvdyiqgblutlpsarxxlhrtbtaeygrttylrxxileanizeibsdxniuibycngkvvfdsprmeciupfwuchsogkjljxeoursggepxjplsrixylhifjfnfgwclbjouebhbkhbeoitfbnvqorwvcnvbempghsxmuelmhptkvganyruktxqfeomlehlbdijvtuktrlxlrghqzwuoahscqbilhvwbleldnckvbbuklxvughyijkguyimkzgdibjcgemgyhlbiavbizzgmpaxibsebficbjjtgmlnuzpgddfhpkixqgdnbpuxctmwogvuzodwfpsabmuungtznifimlxovyusotvcmybktzxhrtiqeglpewidnwgwmbuymwlspuqeywazlacqujslpajdnbzthhkmlqxhpomeowfiahxhunevjwbtfzqlrqrsdtctammbyfdprxpcxbdrovbefhvxkrzlhhofiqopjokvmzqrxairrfsajccgjwnvtoxdcubikavdmzizixqfsnubzphdwlsdafijoouiikbyykhumadwitrpnuuzpvqyqmeujbfwufcorrqqaucfbjpqoidloqoorohahnpciyxqycfbhycwfsnoddaetcjriaeljxjofihxpszqmmdlbcmicdxkqmnwdtteoyjnljsesofazaxosmckvkdszyncbprjhhlboqxfahrzfomqtkcohviozvtxfaaakwkjldktusqaddapxgclhyggehftvsnbtzjpnfkujyhfgogzerxsjbuzeiwjsdrmacvaesbbnwdaiuojtxlbpccxpskgknsghngttxgkiydfvasweoewjzweakjqzikimlxxkyiszehntjvvpcpxiyigarewsxykqserwxkiwbppnqlqkbgrfcwjudknlqouvvnpfsizjuarnhojrzchstldmymztrgixxnlgjlifvaybjtbpyijfkhhvcakqtarhxcscnkcafgyccytfrodtoimpsilvedapfazrqqwgozeubcllnmwajsnztcnoqfivsqtcueqlghtzjnztltflisacmacztufhuthonmhaqotjjdefqjjejrwinzxxvheplmktrxgjjiwaupltxrezqnwyqbcnivbczmlagzqpsubgzierxgrbscwxmjkkjqoypxsfyibcgvwrybxgnvnkfxpitisdcmseasrqqezxlozncflpojwyzripqnyrkzbmrtdpkwxdsmweosgwsztlvnjsyemklltqkhcbcehvxttvzorhmyktfjypwnrjkvrvqrlftbfijexknlhsqxpohkmietfzutpmcnokyckvlctkmlovvppcuxohttujnrxxgtjiiknmrjsvmuhalmbafnarufwuyhxmcatalgjrhtwuynfxitnlcglbpciealputselzkjzojktuaowjdpzjdjbzvtbjspatlsyognbfzfkdlfdljahqmrhcrwflcgiglmedromwpzcxuqgaxzzjccvybpkamvibtofrqdhzwknjmbpdxoclewaprrxgjzzwamcrsyspqbwtahfxiizqgmjsztsbofrhtyulezrddmccgdzufizcqbvbcstpvfhreafunxjdqxkgbzkkritvfvgpqrqinceiuwwrzdrlihpreervfyhqmnfqvjbbsswqylsfitppijgzraonjnarucfzrapjbfayaymgnnkhhrxwwoyhvylorrfjzhyunkwmoxjpbveeicalsgvcljaxcuopqchhwpuexeynlkonuknwtdglwcgbhptacbmllwhhvtpprvfqbfihzpjccpmtazxsntrsryupiwlarhytcufabgrtskvgxjnpzslgleoremxkrqlqgayvpuxhlucldtrgqwncecwigbtoiogubrjzrfvmkssmczkupgncyqzapwtfmkazkiylfsscmlxqtibzyptitbuqsclejaebtrhcwblfyhkaakrnturrxyzpreomndunvnezkroytxyqqcqkcvvvwkkcpnjualptzpjdhmzysamdpeixgieauatndertfbgwanwlrpnzlzakrpbcysyxkoksfjujybvceioqfcgzxavrlxqwhkuchapmsfopifejgumfvdvkkjgmgnrihbvfyxowoyrkhqwnyfgevhntzwctejjbubkbfdzryyrtlycdykkzzdckbxmufdmooawpftfjskrugbmahjqsqivrnheqpngvzrrxzxybabtjwgnrkdwbtwgkcljtebfotkjazcvgfekhxdudddihmqujvxjzwrkzvlcjslwaadeegmqfzqtpylfkeyudcnknlakdolcazfbeuntnlimycrulqusdbbblazsxfxnghykiivkxxifcmcwdojatvituplmypaqseskfjwwntkiydvxoulcpwdezxerdnyszsdxqldsrotconbqllwthtxokagqyqtkjksaanxqfjcvfwhfhvkvzfjybmjtphtjbqxweymyptlxlgguswukxtptsdlmiidlohltuixgrsvsarxvwuadcxrxvkyvyaiahfogytbpicqcfnykzgctpsuezgwmsaquzaszyxfvgcdloidapwwtkduxplxjgigxsfxwwfnkcmcqisdnhcpibecbaerivjqwjsfrzwtydbkxugftddurniyfzerxcriywvyaacmbjjkopmoityaacbkborvmmgezipvceiewcvczqlgjzfxwijaurpgeekrowkwlefaktcjeoddefatttsaxqdvqhbmgedxtzcxcebqzbdxatkamrxjkjljuscoujnaquxipuixmqtlrlalzaferrrrtuqmogcqontoxsiqmaobqozhyvcmgpgjrwywherxatrmujryfbtwwbfejibplzbcsykfdzgtpwejeomqozgruhctuvdggljblopyfhpliufavdxigeuwmbvthgcfccfdhvdiuyzmyxqvyutfkvzyrmrdtplwrzmuneroboxxbilracddybfnsximdsgmccfgwkobyrrkpazqmkufmgdxsebruybfzphtjditufjuklgsyuyduvttabiecfacxfktesqpkbfuuvppfxbohtrkysmglwkogchswhqtprqszxlucxdnpqrtygelrqutxeiggxjqdqpydybdrzeeamjowdhixidjrioyarfegshsfqcpfowdrhexudtukqdfjcyfzfasxyiulmcdneguhghzgvfftmscufkdphfoxzccnnoqflhrommlbmxbyisezwcuwopkvfohimghrjgrdlhiootyrjzwbgzogguyuhydlnkrwqfpamfjemegeanccnfjhkgqkyfzizqvlndlvjcrbrbjmqjvmhfuaqtzphjlozxgmvjdusczmmuomysnrqrxlucsiorerdjopqixmvwootraihhgvyxwocesvdwpjhiibqkoohjuadnrllrihvthoglcvplbkiggwcexxrzolfnbkoftyiursorjzagwouaecbmfdjgvpattajyvhhkavvcmimtwaijgazpposfkbwocdbkfxdhhgqohpbfcydhzotivutxpfunfwjkcjcienguatoovurpogecnioomeomhvoehhnjypquhbcqrzurbwkatvtjfjtopbznoovpsdbslvvvwfixrcbsybwnjbpdtqfraimgacfjpiprhckubknmqmobqviewtpbzgtbwkabvxnwsojfbkrefvvnmkkwxwoilvzulodjbcadtnqorzsnpgyrggycjfxfkpdhkmxgznqxmkqytnretlbdjuntwxklqfvwsppriurjelistwgqwobtyqhtqxehbysmpsduqitotixuyzmbgialpazerzhuwkgrtqjqwzgscpnmpxvwiwblfctffwajtiuvtlphhufrykgqxbpdtlawyacickvrpnpnskvstfyolxseptdkxrwnoareljubdrvgnxugiwoyujaswrgflvxsktvgzupjmodyhcxhzabotucuidihnmqfryaceligqqzuikdyvjpukyxdnqrjcyycwvnknqtfwjtlavfvvatxwdxanwbvilbyiqmsiikyoryviudhzrinqqdzinycacnqpzigtoifufwuenhetudqnlxqvkluiycofgjdskjdkxrjzkovvhpsevgxbverptrjyzbbhanpnihpzjteihdjauqvkeohlhbmxqrkvkpgnwfhygltkgvlhifeguygsonnqltotuwjwmijvnwwaiiqzvktgbfnyvjsrvoicvmnqubsmvxxmbteoxluohdwtyvfnclvqnpgztxjgupvprgesxttoaemvjlrgfefhoxwwebztpyfcgoiufqgenlfecldbafoiydgbwioznkxqmgtnluwuldexucxzdsxsdjshdewxjaefzltrrhqiiiodypijcdzlsnehhednigmmvvphamjkrurgirjseajhxjvsurupgpvwdcawliuilhszczxkedyqnsjpjpbrcmxlrojakwqrimdypqginkxejbvsrfrjmgnblficxfqiuywtxozoammclpmttvfrczvhhkfxajnjrirfqoywpkhhliupjqhenaodfumtuggnbaokqjdwqwcpbqvbneblfcjcewotnaaslk"));

        var longestPalindrome = longestPalindrome("babad");
        Assertions.assertTrue("aba".equals(longestPalindrome) || "bab".equalsIgnoreCase(longestPalindrome));
    }
}
