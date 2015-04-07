package parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import bit_dec.dissambler.DisBlock;
import bit_dec.dissambler.DisFunction;
import bit_dec.dissambler.DisInst;
public class HexParser {
		/**��Ժ������֣�����**/
		// ���������
		private ArrayList<DisFunction> functionslist = new ArrayList<DisFunction>();
		private Map<String, Boolean> Funadrpass = new HashMap<String,Boolean>();
		private ArrayList<String> funcalladdresses = new ArrayList<String>();
		private void AddToFunCalladdr(String address)
		{
			address = address.toUpperCase();
			if(!funcalladdresses.contains(address))
			{
				funcalladdresses.add(address);
			}
		}
		
		//��¼������ת�ͽ���ʱ��ĵ�
		/**���캯����Ҫ����hex�ļ���ȷ��·����hex�ļ�����(PIC����8051)**/
		/**
		 * �����黮�ֺͿ�����ͼ   ��������
		 * **/
		private ArrayList<String> block_head_address = new ArrayList<String>();
		private void addBlockHead(String addr)
		{
			if(addr.equals(""))
			{
				return;
			}
			if(!block_head_address.contains(addr))
			{
				block_head_address.add(addr);
			}
		}
		/**
		 * �����黮�ֺͿ�����ͼ
		 * **/
		//ÿһ��ָ����뵽  DisInst ��ȥ
		/**��¼��������pichex����51hex**/
		private boolean PIC = false;
		private boolean I51 = false;
//		private int head = 1;
//		private int tail = 2;
//		private int notHeadAndTail = 0;
		/**��ת��ַ������ջ**/
		private Stack<Integer> stack_remember_JMP = new Stack<Integer>();
		private ArrayList<String> addrNextRet = new ArrayList<String>();
		private void addNextRet(String adr)
		{
			if(!PassAdrs.get(adr))
			{
				addrNextRet.add(adr);
			}
		}
		/**DisInst�飬���д����ݿ�ʼʱ�������ĵ�ַ�Լ��������**/
		public static ArrayList<DisInst> instslist = new ArrayList<DisInst>();
		
		
		/**���hex�ļ���ַ**/
		private String hexpath = "";
		/**��¼��ַ��arraylist**/
		ArrayList<String> address_list = new ArrayList<String>();
		/**��¼��ַ�Ƿ����õ�hashmap**///false��ʾû�о�����ǰ��ַ
		private Map<String, Boolean> PassAdrs = new HashMap<String,Boolean>();
		//private Map<String, Integer> InsMap51 = null;
		/**��¼��ַ�������ݵ�arraylist**/
		ArrayList<String> data_inaddress_list = new ArrayList<String>();

		/**��������map�ṹ�ļ������ڲ�ѯ�����������**/
//		private Map<String, Integer> InsMap51 = null;
		private ArrayList<String> one_bits_ins_list = null;
		private ArrayList<String> two_bits_ins_list = null;
		private ArrayList<String> three_bits_ins_list = null;
		/**���캯��**/
		public HexParser(String hexpath,String hextype)
		{
			if(hextype.equals("PIC"))
			{
				PIC = true;
			}
			if(hextype.equals("8051"))
			{
				I51 = true;
			}
			this.hexpath = hexpath;
			//InsMap51 = initializeMap();
			one_bits_ins_list = initialize_1bits_List();
			two_bits_ins_list = initialize_2bits_List();
			three_bits_ins_list = initialize_3bits_List();
			/**��ʼ��hex�ļ���������ݽ�����addresslist��datalist��**/
			try {
				strart();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}

		}
		/***********************************************/
		/***********ģ������********************************************/
		
		/*******************************************************/
		/**��¼hex�ļ���ÿһ�и���λ�ã���Щֵ����**/
	
		//���ݳ��ȼ�¼��ʼ�ͽ���λ��
		private int datalenbegin = 1;
		private int datalenend = 3;
		//�׵�ַ��ʼλ�úͽ���λ��
		private int first_adr_begin = 3;
		private int first_adr_end = 7;
		//���ݿ�ʼ��λ��
		private int databegin = 9;
		
		/***********************************************/
		
		/****************begin**��****��***��****��***************************/
		/**��ת��ַ+ƫ����**/

		private void push(String adr)
		{
			String addr = adr.toUpperCase();
			int at = address_list.indexOf(addr);
			if(at==-1)
			{
				//System.out.println("�������ĵ�ַ"+addr);
				return;
			}

			if(!stack_remember_JMP.contains(at))
			{
				//System.out.println("ѹ���ַ"+address_list.get(at));
				stack_remember_JMP.push(at);
			}
		}
		
		private int pop()
		{
			if(stack_remember_JMP.isEmpty())
			{
				return -1;
			}
			return stack_remember_JMP.pop();
		}
		private String tobinary(String hex)
		{
			int a = Integer.parseInt(hex,16);
			int hexlen = hex.length();
			int blen = hexlen*4;
			String b = Integer.toBinaryString(a);
			int len = b.length();
			for (int i = blen; i >len; i--) {
				b = "0"+b;
			}
			return b;
		}
		private String binaryqufan(String a)
		{
			StringBuffer b = new StringBuffer();
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i)=='0')
				{
					b.append("1");
				}
				else
				{
					b.append("0");
				}
			}
			return b.toString();
		}
		private String JumpAddressAdd(String address,String offset)
		{
			String hexa = address;
			int alen = hexa.length();
			String hexb = offset;
			int blen = hexb.length();
			String bina = tobinary(hexa);
			String binb = tobinary(hexb);
			int inta = Integer.parseInt(bina,2);
			//System.out.println("a�Ķ�����ת��Ϊ10���ƽ��"+inta);
			int intb = 0;
			if(binb.charAt(0) == '1')
			{
				String qufan = binaryqufan(binb.substring(1));
				intb = 0 - (Integer.parseInt(qufan,2)+1);
				
			}
			else{
				intb = Integer.parseInt(binb,2);
			}
			int renum = inta+intb;
			int len = 0;
			if(alen>blen)
			{
				len = alen;
			}
			else{
				len = blen;
			}
			String re = Integer.toHexString(renum);
			renum = re.length();
			for (int i = len; i > renum; i--) 
			{
				re = "0"+re;
			}
			return re.toUpperCase();
		}

		/**��ַ����num**/
		private String AddressAddNum(String address,int num)
		{
			int tp = Integer.parseInt(address,16);
			tp += num;
			String re = Integer.toHexString(tp);
			int relen = re.length();
			for (int i = 4; i >relen; i--) {
				re = "0"+re;
			}
			return re;
		}
		/**16����ת2����**/
		private String Hex2Binary(String hexString)
		{
			int binarylen = hexString.length()*4;
			int tempnum = Integer.parseInt(hexString,16);
			String binaryString = Integer.toBinaryString(tempnum);
			int nowbinarylen = binaryString.length();
			for (int i = binarylen; i>nowbinarylen; i--) {
				binaryString = "0"+binaryString;
			}
			return binaryString;
		}
		/**2����ת16����**/
		private String Binary2Hex(String binaryString)
		{
			int binarylen = binaryString.length();
			int tempnum = Integer.parseInt(binaryString,2);
			String hexString = Integer.toHexString(tempnum);
			int hexlen = binarylen/4;
			if(binarylen%4!=0)
			{
				hexlen ++;
			}
			int hexStringlen = hexString.length();
			for (int i = hexlen; i > hexStringlen; i--) {
				hexString = "0"+hexString;
			}
			return hexString.toUpperCase();
		}
		
		private void AddToDisInst(String address,String ins,String zhujifu,String args)
		{
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setAssCode(zhujifu);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.addArgs(args);
			instslist.add(disInst);
		}
		private void AddToDisInst(String address,String ins,String zhujifu,String args1,String args2)
		{
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setAssCode(zhujifu);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.addArgs(args1);
			disInst.addArgs(args2);
			instslist.add(disInst);
		}
		

		
		private void PassAdr(String adr)//��adr��ַ��Ӧ��map.value ��Ϊtrue  ��ʾ�Ѿ�����
		{
			PassAdrs.put(adr, true);
		}

		private boolean HEXbetween(String ins,String low,String high) //�Ƚ�hex�Ƿ���low��high֮��
		{
			String hex = "";
			hex = ins;
			boolean between = false;
			int he = Integer.parseInt(hex,16);
			int lo = Integer.parseInt(low,16);
			int hi = Integer.parseInt(high,16);
			if(lo<=he&&he<=hi)
			{
				between = true;
			}
			return between;
		}
		
		/****************end**��****��***��****��***************************/	
		
		
		/**��ʼ������map�ĺ���**/
		/*
		private Map<String, Integer> initializeMap()//���е�ָ�������ֽڳ�ʼ����insmap51
		{	
			 Map<String, Integer> map = new  HashMap<String, Integer>();
				map.put("00",1);
				map.put("03",1);
				map.put("04",1);
				map.put("06",1);
				map.put("07",1);
				map.put("08",1);
				map.put("09",1);
				map.put("0A",1);
				map.put("0B",1);
				map.put("0C",1);
				map.put("0D",1);
				map.put("0E",1);
				map.put("0F",1);
				map.put("13",1);
				map.put("14",1);
				map.put("16",1);
				map.put("17",1);
				map.put("18",1);
				map.put("19",1);
				map.put("1A",1);
				map.put("1B",1);
				map.put("1C",1);
				map.put("1D",1);
				map.put("1E",1);
				map.put("1F",1);
				map.put("22",1);
				map.put("23",1);
				map.put("26",1);
				map.put("27",1);
				map.put("28",1);
				map.put("29",1);
				map.put("2A",1);
				map.put("2B",1);
				map.put("2C",1);
				map.put("2D",1);
				map.put("2E",1);
				map.put("2F",1);
				map.put("32",1);
				map.put("33",1);
				map.put("36",1);
				map.put("37",1);
				map.put("38",1);
				map.put("39",1);
				map.put("3A",1);
				map.put("3B",1);
				map.put("3C",1);
				map.put("3D",1);
				map.put("3E",1);
				map.put("3F",1);
				map.put("46",1);
				map.put("47",1);
				map.put("48",1);
				map.put("49",1);
				map.put("4A",1);
				map.put("4B",1);
				map.put("4C",1);
				map.put("4D",1);
				map.put("4E",1);
				map.put("4F",1);
				map.put("56",1);
				map.put("57",1);
				map.put("58",1);
				map.put("59",1);
				map.put("5A",1);
				map.put("5B",1);
				map.put("5C",1);
				map.put("5D",1);
				map.put("5E",1);
				map.put("5F",1);
				map.put("66",1);
				map.put("67",1);
				map.put("68",1);
				map.put("69",1);
				map.put("6A",1);
				map.put("6B",1);
				map.put("6C",1);
				map.put("6D",1);
				map.put("6E",1);
				map.put("6F",1);
				map.put("73",1);
				map.put("83",1);
				map.put("84",1);
				map.put("93",1);
				map.put("96",1);
				map.put("97",1);
				map.put("98",1);
				map.put("99",1);
				map.put("9A",1);
				map.put("9B",1);
				map.put("9C",1);
				map.put("9D",1);
				map.put("9E",1);
				map.put("9F",1);
				map.put("A3",1);
				map.put("A4",1);
				map.put("B3",1);
				map.put("C3",1);
				map.put("C4",1);
				map.put("C6",1);
				map.put("C7",1);
				map.put("C8",1);
				map.put("C9",1);
				map.put("CA",1);
				map.put("CB",1);
				map.put("CC",1);
				map.put("CD",1);
				map.put("CE",1);
				map.put("CF",1);
				map.put("D3",1);
				map.put("D4",1);
				map.put("D6",1);
				map.put("D7",1);
				map.put("E0",1);
				map.put("E2",1);
				map.put("E3",1);
				map.put("E4",1);
				map.put("E6",1);
				map.put("E7",1);
				map.put("E8",1);
				map.put("E9",1);
				map.put("EA",1);
				map.put("EB",1);
				map.put("EC",1);
				map.put("ED",1);
				map.put("EE",1);
				map.put("EF",1);
				map.put("F0",1);
				map.put("F2",1);
				map.put("F3",1);
				map.put("F4",1);
				map.put("F6",1);
				map.put("F7",1);
				map.put("F8",1);
				map.put("F9",1);
				map.put("FA",1);
				map.put("FB",1);
				map.put("FC",1);
				map.put("FD",1);
				map.put("FE",1);
				map.put("FF",1);
				map.put("05",2);
				map.put("15",2);
				map.put("24",2);
				map.put("25",2);
				map.put("34",2);
				map.put("35",2);
				map.put("40",2);
				map.put("42",2);
				map.put("44",2);
				map.put("45",2);
				map.put("50",2);
				map.put("52",2);
				map.put("54",2);
				map.put("55",2);
				map.put("60",2);
				map.put("62",2);
				map.put("64",2);
				map.put("65",2);
				map.put("70",2);
				map.put("72",2);
				map.put("74",2);
				map.put("76",2);
				map.put("77",2);
				map.put("78",2);
				map.put("79",2);
				map.put("7A",2);
				map.put("7B",2);
				map.put("7C",2);
				map.put("7D",2);
				map.put("7E",2);
				map.put("7F",2);
				map.put("80",2);
				map.put("82",2);
				map.put("86",2);
				map.put("87",2);
				map.put("88",2);
				map.put("89",2);
				map.put("8A",2);
				map.put("8B",2);
				map.put("8C",2);
				map.put("8D",2);
				map.put("8E",2);
				map.put("8F",2);
				map.put("92",2);
				map.put("94",2);
				map.put("95",2);
				map.put("A0",2);
				map.put("A2",2);
				map.put("A6",2);
				map.put("A7",2);
				map.put("A8",2);
				map.put("A9",2);
				map.put("AA",2);
				map.put("AB",2);
				map.put("AC",2);
				map.put("AD",2);
				map.put("AE",2);
				map.put("AF",2);
				map.put("B0",2);
				map.put("B2",2);
				map.put("C0",2);
				map.put("C2",2);
				map.put("C5",2);
				map.put("D0",2);
				map.put("D2",2);
				map.put("D8",2);
				map.put("D9",2);
				map.put("DA",2);
				map.put("DB",2);
				map.put("DC",2);
				map.put("DD",2);
				map.put("DE",2);
				map.put("DF",2);
				map.put("E5",2);
				map.put("F5",2);
				map.put("02",3);
				map.put("10",3);
				map.put("12",3);
				map.put("20",3);
				map.put("30",3);
				map.put("43",3);
				map.put("53",3);
				map.put("63",3);
				map.put("75",3);
				map.put("85",3);
				map.put("90",3);
				map.put("B4",3);
				map.put("B5",3);
				map.put("B6",3);
				map.put("B7",3);
				map.put("B8",3);
				map.put("B9",3);
				map.put("BA",3);
				map.put("BB",3);
				map.put("BC",3);
				map.put("BD",3);
				map.put("BE",3);
				map.put("BF",3);
				map.put("D5",3);
			return map;
		}
		*/
		
		/**��ʼ��1�ֽ������б�**/
		private ArrayList<String> initialize_1bits_List()
		{
			ArrayList<String> list = new ArrayList<String>();
			list.add("00");
			list.add("03");
			list.add("04");
			list.add("06");
			list.add("07");
			list.add("08");
			list.add("09");
			list.add("0A");
			list.add("0B");
			list.add("0C");
			list.add("0D");
			list.add("0E");
			list.add("0F");
			list.add("13");
			list.add("14");
			list.add("16");
			list.add("17");
			list.add("18");
			list.add("19");
			list.add("1A");
			list.add("1B");
			list.add("1C");
			list.add("1D");
			list.add("1E");
			list.add("1F");
			list.add("22");
			list.add("23");
			list.add("26");
			list.add("27");
			list.add("28");
			list.add("29");
			list.add("2A");
			list.add("2B");
			list.add("2C");
			list.add("2D");
			list.add("2E");
			list.add("2F");
			list.add("32");
			list.add("33");
			list.add("36");
			list.add("37");
			list.add("38");
			list.add("39");
			list.add("3A");
			list.add("3B");
			list.add("3C");
			list.add("3D");
			list.add("3E");
			list.add("3F");
			list.add("46");
			list.add("47");
			list.add("48");
			list.add("49");
			list.add("4A");
			list.add("4B");
			list.add("4C");
			list.add("4D");
			list.add("4E");
			list.add("4F");
			list.add("56");
			list.add("57");
			list.add("58");
			list.add("59");
			list.add("5A");
			list.add("5B");
			list.add("5C");
			list.add("5D");
			list.add("5E");
			list.add("5F");
			list.add("66");
			list.add("67");
			list.add("68");
			list.add("69");
			list.add("6A");
			list.add("6B");
			list.add("6C");
			list.add("6D");
			list.add("6E");
			list.add("6F");
			list.add("73");
			list.add("83");
			list.add("84");
			list.add("93");
			list.add("96");
			list.add("97");
			list.add("98");
			list.add("99");
			list.add("9A");
			list.add("9B");
			list.add("9C");
			list.add("9D");
			list.add("9E");
			list.add("9F");
			list.add("A3");
			list.add("A4");
			list.add("B3");
			list.add("C3");
			list.add("C4");
			list.add("C6");
			list.add("C7");
			list.add("C8");
			list.add("C9");
			list.add("CA");
			list.add("CB");
			list.add("CC");
			list.add("CD");
			list.add("CE");
			list.add("CF");
			list.add("D3");
			list.add("D4");
			list.add("D6");
			list.add("D7");
			list.add("E0");
			list.add("E2");
			list.add("E3");
			list.add("E4");
			list.add("E6");
			list.add("E7");
			list.add("E8");
			list.add("E9");
			list.add("EA");
			list.add("EB");
			list.add("EC");
			list.add("ED");
			list.add("EE");
			list.add("EF");
			list.add("F0");
			list.add("F2");
			list.add("F3");
			list.add("F4");
			list.add("F6");
			list.add("F7");
			list.add("F8");
			list.add("F9");
			list.add("FA");
			list.add("FB");
			list.add("FC");
			list.add("FD");
			list.add("FE");
			list.add("FF");
			return list;
		}
		/**��ʼ��2�ֽ������б�**/
		private ArrayList<String> initialize_2bits_List()
		{
			ArrayList<String> list = new ArrayList<String>();
			list.add("05");
			list.add("15");
			list.add("24");
			list.add("25");
			list.add("34");
			list.add("35");
			list.add("40");
			list.add("42");
			list.add("44");
			list.add("45");
			list.add("50");
			list.add("52");
			list.add("54");
			list.add("55");
			list.add("60");
			list.add("62");
			list.add("64");
			list.add("65");
			list.add("70");
			list.add("72");
			list.add("74");
			list.add("76");
			list.add("77");
			list.add("78");
			list.add("79");
			list.add("7A");
			list.add("7B");
			list.add("7C");
			list.add("7D");
			list.add("7E");
			list.add("7F");
			list.add("80");
			list.add("82");
			list.add("86");
			list.add("87");
			list.add("88");
			list.add("89");
			list.add("8A");
			list.add("8B");
			list.add("8C");
			list.add("8D");
			list.add("8E");
			list.add("8F");
			list.add("92");
			list.add("94");
			list.add("95");
			list.add("A0");
			list.add("A2");
			list.add("A6");
			list.add("A7");
			list.add("A8");
			list.add("A9");
			list.add("AA");
			list.add("AB");
			list.add("AC");
			list.add("AD");
			list.add("AE");
			list.add("AF");
			list.add("B0");
			list.add("B2");
			list.add("C0");
			list.add("C2");
			list.add("C5");
			list.add("D0");
			list.add("D2");
			list.add("D8");
			list.add("D9");
			list.add("DA");
			list.add("DB");
			list.add("DC");
			list.add("DD");
			list.add("DE");
			list.add("DF");
			list.add("E5");
			list.add("F5");
			return list;
		}
		/**��ʼ��3�ֽ������б�**/
		private ArrayList<String> initialize_3bits_List()
		{
			ArrayList<String> list = new ArrayList<String>();
			list.add("02");
			list.add("10");
			list.add("12");
			list.add("20");
			list.add("30");
			list.add("43");
			list.add("53");
			list.add("63");
			list.add("75");
			list.add("85");
			list.add("90");
			list.add("B4");
			list.add("B5");
			list.add("B6");
			list.add("B7");
			list.add("B8");
			list.add("B9");
			list.add("BA");
			list.add("BB");
			list.add("BC");
			list.add("BD");
			list.add("BE");
			list.add("BF");
			list.add("D5");
			return list;
		}
		private boolean Line_dayu(String line1,String line2)
		{
			String address1 = line1.substring(first_adr_begin,first_adr_end);
			String address2 = line2.substring(first_adr_begin,first_adr_end);
			return a_dayu_b(address1, address2);
		}
		private boolean a_dayu_b(String a,String b)
		{
			int anum = Integer.parseInt(a,16);
			int bnum = Integer.parseInt(b,16);
			if(anum>bnum)
			{
				return true;
			}
			return false;
		}
		/**��������    �׳��쳣**/
		private void strart() throws IOException
		{
			/**
			 *��ʼ��ȡhex�ļ����� 
			 **/
			ArrayList<String> linelist = new ArrayList<String>();
			File hexFile = new File(hexpath);
			FileInputStream hexin = new FileInputStream(hexFile);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(hexin)
					);
			String lineString = "";
			while((lineString = reader.readLine())!=null)
			{
				linelist.add(lineString);//toParserLine(lineString);//ÿһ��һ�δ���
			}
			reader.close();
			for (int i = 1; i < linelist.size(); i++) {
				String line1 = linelist.get(i-1);
				String line2 = linelist.get(i);
				if(Line_dayu(line1, line2))
				{
					linelist.set(i-1, line2);
					linelist.set(i, line1);
					i = 0;
				}
			}
			for (int i = 0; i < linelist.size(); i++) {
				toParserLine(linelist.get(i));
			}
			//sort();
		}
		
		/**��ʼ����һ��**/
		private void toParserLine(String line)
		{
			int linelen = line.length();
			String data_len = line.substring(datalenbegin,datalenend);
			int datalen = Integer.parseInt(data_len,16);//16����ת10����
			String firstaddress = line.substring(first_adr_begin,first_adr_end);
			//String datatype = line.substring(datatypebegin,datatypeend);
			String data = line.substring(databegin,linelen-2);//line�����λֵУ����
			/**����������ַ������һһ��Ӧ**/
			String tempaddress = firstaddress;
			String tempdata = data;
			//_51MAPVALUE value = null;
			String binary = "";
			for (int i = 0; i < datalen; i++) 
			{
				tempaddress = AddressAddNum(firstaddress, i);
				binary = tempdata.substring(0,2);
				address_list.add(tempaddress.toUpperCase());
				PassAdrs.put(tempaddress.toUpperCase(), false);//false��ʾû�о�����ǰ��ַ
				Funadrpass.put(tempaddress.toUpperCase(), false);//false��ʾû�о�����ǰ��ַ
				data_inaddress_list.add(binary.toUpperCase());
				tempdata = tempdata.substring(2);
			}
		}
		/**����һ�н���**/
		
		/********************************************************************************/
		/**��ʼ����8051����**/
		
		// ��DisInst��ȥ���Ƿ����һ�������ĵ�ַ������
		private DisInst findDisInst(ArrayList<DisInst> list,String adr)
		{
			DisInst disInst = null;
			for (int i = 0; i < list.size(); i++) {
				disInst = list.get(i);
				String listadr = disInst.getAddr().toUpperCase();
				if(listadr.equals(adr.toUpperCase()))
				{
					return disInst;					
				}
			}
			return null;
		}
		/******************ָ���**********************/
		/**����Ĳ���Ϊ��(ָ��Ķ����Ƹ�ʽ��ָ��Ļ�����ʽ��([������ַ����] [������ַ����])��ָ��ĵ�ַ����)**/
		/**1�ֽ�ָ��* �������п��ܵ���һ��ַ������ֵ*/
		private int deal1(String ins,int insAt)
		{	
			int next = -1;
			
			if(ins.equals("04")||ins.equals("A3")||HEXbetween(ins, "06", "0F"))   ///  INC04  A+1���� A3 ����ָ��+1 ������06 - 0F 
			{
				next = INC1(insAt);
			}
			else if(ins.equals("14")||HEXbetween(ins, "16", "1F"))
			{
				next = DEC1(insAt);
			}
			else if(HEXbetween(ins, "26", "2F"))
			{
				next = ADD1(insAt);
			}
			else if(HEXbetween(ins, "36", "3F"))
			{
				next = ADDC1(insAt);
			}
			else if(HEXbetween(ins, "56", "5F"))
			{
				next = ANL1(insAt);
			}
			else if(ins.equals("C3")||ins.equals("E4"))
			{
				next = CLR1(insAt);
			}
			else if(ins.equals("D3"))
			{
				next = SETB1(insAt);
			}
			else if(ins.equals("C4"))
			{
				next = SWAP1(insAt);
			}
			else if(ins.equals("F4")||ins.equals("B3"))
			{
				next = CPL1(insAt);
			}
			else if(ins.equals("D4"))
			{
				next = DA1(insAt);
			}
			else if(ins.equals("84"))
			{
				next = DIV1(insAt);
			}
			else if(ins.equals("A4"))
			{
				next = MUL1(insAt);
			}
			else if(ins.equals("00"))
			{
				next = NOP(insAt);
			}
			else if(ins.equals("22"))
			{
				next = RET1(insAt);
			}
			else if(ins.equals("32"))
			{
				next = RETI1(insAt);
			}
			else if(ins.equals("23")||ins.equals("33"))
			{
				next = RL1(insAt);
			}
			else if(ins.equals("03")||ins.equals("13"))
			{
				next = RR1(insAt);
			}
			else if(HEXbetween(ins, "96", "9F"))
			{
				next = SUBB1(insAt);
			}
			else if(HEXbetween(ins, "C6", "CF"))
			{
				next = XCH1(insAt);
			}
			else if(HEXbetween(ins, "66", "6F"))
			{
				next = XRL1(insAt);
			}
			else if(HEXbetween(ins, "46","4F"))
			{
				next = ORL1(insAt);
			}
			else if(ins.equals("73"))
			{
				next = JMP1(insAt);
			}
			//E6-EF   F6-FF   83  93  E2 E3 E0 F2 F3 F0
			else if(ins.equals("83")||ins.equals("93")||
					ins.equals("E2")||ins.equals("E3")||ins.equals("E0")||
					ins.equals("F2")||ins.equals("F3")||ins.equals("F0")||
					HEXbetween(ins, "E6", "EF")||HEXbetween(ins, "F6", "FF"))
			{
				next = MOV1(insAt);
			}
			//System.out.println(insAt+" ��һ�ֽ�����,��һ����"+next);
			return next;
		}
		/**2�ֽ�ָ��* �������п��ܵ���һ��ַ������ֵ*/
		private int deal2(String ins,int insAt)
		{
			int next = -1;
			if(ins.equals("25")||ins.equals("24"))
			{
				next = ADD2(insAt);
			}
			else if(ins.equals("35")||ins.equals("34")) 
			{
				next = ADDC2(insAt);
			}
			else if(ins.equals("52")||ins.equals("54")||ins.equals("55")||
					ins.equals("82")||ins.equals("B0"))
			{
				next = ANL2(insAt);
			}
			else if(ins.equals("C2")) 
			{
				next = CLR2(insAt);
			}
			else if(ins.equals("B2")) 
			{
				next = CPL2(insAt);
			}
			else if(ins.equals("15")) 
			{
				next = DEC2(insAt);
			}
			else if(HEXbetween(ins, "D8", "DF")) 
			{
				next = DJNZ2(insAt);
			}
			else if(ins.equals("05")) 
			{
				next = INC2(insAt);
			}
			else if(ins.equals("40")) 
			{
				next = JC2(insAt);
			}
			else if(ins.equals("50")) 
			{
				next = JNC2(insAt);
			}
			else if(ins.equals("70")) 
			{
				next = JNZ2(insAt);
			}
			else if(ins.equals("60")) 
			{
				next =JZ2(insAt) ;
			}
			else if(ins.equals("42")||ins.equals("44")||ins.equals("45")||
					ins.equals("72")||ins.equals("A0")) 
			{
				next =ORL2(insAt);
			}
			else if(ins.equals("D0")) 
			{
				next =POP2(insAt);
			}
			else if(ins.equals("C0")) 
			{
				next =PUSH2(insAt);
			}
			else if(ins.equals("D2")) 
			{
				next = SETB2(insAt);
			}
			else if(ins.equals("80")) 
			{
				next =SJMP2(insAt);
			}
			else if(ins.equals("95")||ins.equals("94")) 
			{
				next =SUBB2(insAt);
			}
			else if(ins.equals("C5")) 
			{
				next =XCH2(insAt);
			}
			else if(ins.equals("62")||ins.equals("64")||ins.equals("65")) 
			{
				next =XRL2(insAt);
			}
			/**E5 74  A6-AF  76-7F  F5  86-8F  A2 92 **/
			else if(ins.equals("92")||ins.equals("F5")||
					ins.equals("A2")||ins.equals("74")||ins.equals("E5")||
					HEXbetween(ins, "A6", "AF")||HEXbetween(ins, "76", "7F")||HEXbetween(ins, "86", "8F"))
			{
				next = MOV2(insAt);
			}
			//System.out.println(insAt+" �����ֽ�����,��һ����"+next);
			return next ;
		}
		
		/**3�ֽ�ָ��* �������п��ܵ���һ��ַ������ֵ*/
		private int deal3(String ins,int insAt)
		{
			int next = -1;
			if(ins.equals("53"))
			{
				next = ANL3(insAt);
			}
			else if(HEXbetween(ins, "B4", "BF"))
			{
				next = CJNE3(insAt);
			}
			else if(ins.equals("D5"))
			{
				next = DJNZ3(insAt);
			}
			else if(ins.equals("20")||ins.equals("10"))
			{
				next = JB3(insAt);
			}
			else if(ins.equals("30"))
			{
				next = JNB3(insAt);
			}
			else if(ins.equals("12"))
			{
				next = LCALL3(insAt);
			}
			else if(ins.equals("02"))
			{
				next = LJMP3(insAt);
			}
			else if(ins.equals("43"))
			{
				next = ORL3(insAt);
			}
			else if(ins.equals("63"))
			{
				next = XRL3(insAt);
			}
			/**85 75 90**/
			else if(ins.equals("85")||ins.equals("75")||ins.equals("90"))
			{
				next = MOV3(insAt);
			}
			//System.out.println(insAt+" �����ֽ�����,��һ����"+next);
			return next;
		}
		
		/*begin*һ�ֽ��������Ƿ�������Ӧ�ĺ���**/
		private int INC1(int insAt)//04  A+1���� A3 ����ָ��+1 ������06 - 0F �Ĵ���(�������@Rn)��1
		{
			String address = address_list.get(insAt);
			//PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("04"))
			{
				zhujifu = "INC A";
			}
			else if(ins.equals("06"))
			{
				zhujifu = "INC @R0";
			}
			else if(ins.equals("07"))
			{
				zhujifu = "INC R1";
			}
			else if(ins.equals("08"))
			{
				zhujifu = "INC R0";
			}
			else if(ins.equals("09"))
			{
				zhujifu = "INC R1";
			}
			else if(ins.equals("0A"))
			{
				zhujifu = "INC R2";
			}
			else if(ins.equals("0B"))
			{
				zhujifu = "INC R3";
			}
			else if(ins.equals("0C"))
			{
				zhujifu = "INC R4";
			}
			else if(ins.equals("0D"))
			{
				zhujifu = "INC R5";
			}
			else if(ins.equals("0E"))
			{
				zhujifu = "INC R6";
			}
			else if(ins.equals("0F"))
			{
				zhujifu = "INC R7";
			}
			else if(ins.equals("A3"))
			{
				zhujifu = "INC DPTR";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int DEC1(int insAt)//14 A-1������16 - 1F �Ĵ���(�������@Rn)��1
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("14"))
			{
				zhujifu = "DEC A";
			}
			else if(ins.equals("16"))
			{
				zhujifu = "DEC @R0";
			}
			else if(ins.equals("17"))
			{
				zhujifu = "DEC @R1";
			}
			else if(ins.equals("18"))
			{
				zhujifu = "DEC R0";
			}
			else if(ins.equals("19"))
			{
				zhujifu = "DEC R1";
			}
			else if(ins.equals("1A"))
			{
				zhujifu = "DEC R2";
			}
			else if(ins.equals("1B"))
			{
				zhujifu = "DEC R3";
			}
			else if(ins.equals("1C"))
			{
				zhujifu = "DEC R4";
			}
			else if(ins.equals("1D"))
			{
				zhujifu = "DEC R5";
			}
			else if(ins.equals("1E"))
			{
				zhujifu = "DEC R6";
			}
			else if(ins.equals("1F"))
			{
				zhujifu = "DEC R7";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int ADD1(int insAt)//26 - 2F  �Ĵ���(�������@Rn)�ӵ�A
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("28"))
			{
				zhujifu = "ADD A,R0";
			}
			else if(ins.equals("29"))
			{
				zhujifu = "ADD A,R1";
			}
			else if(ins.equals("2A"))
			{
				zhujifu = "ADD A,R2";
			}
			else if(ins.equals("2B"))
			{
				zhujifu = "ADD A,R3";
			}
			else if(ins.equals("2C"))
			{
				zhujifu = "ADD A,R4";
			}
			else if(ins.equals("2D"))
			{
				zhujifu = "ADD A,R5";
			}
			else if(ins.equals("2E"))
			{
				zhujifu = "ADD A,R6";
			}
			else if(ins.equals("2F"))
			{
				zhujifu = "ADD A,R7";
			}
			else if(ins.equals("26"))
			{
				zhujifu = "ADD A,@R0";
			}
			else if(ins.equals("27"))
			{
				zhujifu = "ADD A,@R1";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int ADDC1(int insAt)//36 - 3F �Ĵ���(�������@Rn)����λ�ӵ�A
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("36"))
			{
				zhujifu = "ADDC A,@R0";
			}
			else if(ins.equals("37"))
			{
				zhujifu = "ADDC A,@R1";
			}else if(ins.equals("38"))
			{
				zhujifu = "ADDC A,R0";
			}else if(ins.equals("39"))
			{
				zhujifu = "ADDC A,R1";
			}else if(ins.equals("3A"))
			{
				zhujifu = "ADDC A,R2";
			}else if(ins.equals("3B"))
			{
				zhujifu = "ADDC A,R3";
			}else if(ins.equals("3C"))
			{
				zhujifu = "ADDC A,R4";
			}else if(ins.equals("3D"))
			{
				zhujifu = "ADDC A,R5";
			}else if(ins.equals("3E"))
			{
				zhujifu = "ADDC A,R6";
			}else if(ins.equals("3F"))
			{
				zhujifu = "ADDC A,R7";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int ANL1(int insAt)//56 - 5F �Ĵ���(�������@Rn)�뵽A
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("56"))
			{
				zhujifu = "ANL A,@R0";
			}
			else if(ins.equals("57"))
			{
				zhujifu = "ANL A,@R1";
			}
			else if(ins.equals("58"))
			{
				zhujifu = "ANL A,R0";
			}else if(ins.equals("59"))
			{
				zhujifu = "ANL A,R1";
			}else if(ins.equals("5A"))
			{
				zhujifu = "ANL A,R2";
			}else if(ins.equals("5B"))
			{
				zhujifu = "ANL A,R3";
			}else if(ins.equals("5C"))
			{
				zhujifu = "ANL A,R4";
			}else if(ins.equals("5D"))
			{
				zhujifu = "ANL A,R5";
			}else if(ins.equals("5E"))
			{
				zhujifu = "ANL A,R6";
			}else if(ins.equals("5F"))
			{
				zhujifu = "ANL A,R7";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int CLR1(int insAt) //C3   ��λλ��0  E4 �ۼ���A��0ָ��
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("C3"))
			{
				zhujifu = "CLR C";
			}
			else if(ins.equals("E4"))
			{
				zhujifu = "CLR A";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int SETB1(int insAt) //D3 ��λλ��1
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "SETB C";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int SWAP1(int insAt)//C4 	A���ֽڽ���
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "SWAP A";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int CPL1(int insAt) //F4  B3  A����   ��λλȡ��  
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("F4"))
			{
				zhujifu = "CPL A";
			}
			else if(ins.equals("B3"))
			{
				zhujifu = "CPL C";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int DA1(int insAt)// D4  ʮ���Ƶ���
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "DA A";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int DIV1(int insAt)//84   A��B��
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "DIV A,B";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int MUL1(int insAt)//A4   AxB
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "MUL A,B";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}

		private int NOP(int insAt) //00  ��ָ��
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "NOP";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			//insAt = pop();
			if(insAt<address_list.size())
			{
				String adr = address_list.get(insAt);
				push(adr);
			}
			insAt = pop();
			return insAt;
		}
		private int RET1(int insAt) //22  ����ָ��
		{
			String address = address_list.get(insAt);
			//insertinto_return(address);//���뷵���б�
			String ins = data_inaddress_list.get(insAt++);//.toUpperCase();//ȫ�����Ǵ�д
			if(insAt<address_list.size())
			{
				String nextret = address_list.get(insAt);
				addNextRet(nextret);
				addBlockHead(nextret);
			}
			String zhujifu = "";
			zhujifu = "RET";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			PassAdrs.put(address, true);
			insAt = pop();
			return insAt;
		}
		private int RETI1(int insAt)//32 �жϷ���ָ��
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			zhujifu = "RETI";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			PassAdrs.put(address, true);
			insAt = pop();
			return insAt;
		}
		private int RL1(int insAt) //23  33 Aѭ������  Aѭ������λ����
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("23"))
			{
				zhujifu = "RL A";
			}
			else if(ins.equals("33"))
			{
				zhujifu = "RLC A";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int RR1(int insAt)  //03  13 Aѭ������  Aѭ������λ����
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("03"))
			{
				zhujifu = "RR A";
			}
			else if(ins.equals("13"))
			{
				zhujifu = "RRC A";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int SUBB1(int insAt) //96-9F  ��A�м�ȥ�Ĵ�����������ӣ��ͽ�λ
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("96"))
			{
				zhujifu = "SUBB A,@R0";
			}
			else if(ins.equals("97"))
			{
				zhujifu = "SUBB A,@R1";
			}
			else if(ins.equals("98"))
			{
				zhujifu = "SUBB A,R0";
			}
			else if(ins.equals("99"))
			{
				zhujifu = "SUBB A,R1";
			}
			else if(ins.equals("9A"))
			{
				zhujifu = "SUBB A,R2";
			}
			else if(ins.equals("9B"))
			{
				zhujifu = "SUBB A,R3";
			}
			else if(ins.equals("9C"))
			{
				zhujifu = "SUBB A,R4";
			}
			else if(ins.equals("9D"))
			{
				zhujifu = "SUBB A,R5";
			}
			else if(ins.equals("9E"))
			{
				zhujifu = "SUBB A,R6";
			}
			else if(ins.equals("9F"))
			{
				zhujifu = "SUBB A,R7";
			}
			
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int XCH1(int insAt) //C6-CF  �Ĵ�����������ӣ���A���� D6 D7 ���Rn��A�Ͱ��ֽڽ���
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("C6"))
			{
				zhujifu = "XCH A,@R0";
			}
			else if(ins.equals("C7"))
			{
				zhujifu = "XCH A,@R1";
			}
			else if(ins.equals("C8"))
			{
				zhujifu = "XCH A,R0";
			}
			else if(ins.equals("C9"))
			{
				zhujifu = "XCH A,R1";
			}
			else if(ins.equals("CA"))
			{
				zhujifu = "XCH A,R2";
			}
			else if(ins.equals("CB"))
			{
				zhujifu = "XCH A,R3";
			}
			else if(ins.equals("CC"))
			{
				zhujifu = "XCH A,R4";
			}
			else if(ins.equals("CD"))
			{
				zhujifu = "XCH A,R5";
			}
			else if(ins.equals("CE"))
			{
				zhujifu = "XCH A,R6";
			}
			else if(ins.equals("CF"))
			{
				zhujifu = "XCH A,R7";
			}
			else if(ins.equals("D6"))
			{
				zhujifu = "XCHD A,@R0";
			}else if(ins.equals("D7"))
			{
				zhujifu = "XCHD A,@R1";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int ORL1(int insAt)//46 -4F
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);//ȫ�����Ǵ�д
			String zhujifu = "";
			PassAdr(address);
			if(ins.equals("46"))
			{
				zhujifu = "ORL A,@R0";
			}
			else if(ins.equals("47"))
			{
				zhujifu = "ORL A,@R1";
			}
			else if(ins.equals("48"))
			{
				zhujifu = "ORL A,R0";
			}
			else if(ins.equals("49"))
			{
				zhujifu = "ORL A,R1";
			}
			else if(ins.equals("4A"))
			{
				zhujifu = "ORL A,R2";
			}
			else if(ins.equals("4B"))
			{
				zhujifu = "ORL A,R3";
			}
			else if(ins.equals("4C"))
			{
				zhujifu = "ORL A,R4";
			}
			else if(ins.equals("4D"))
			{
				zhujifu = "ORL A,R5";
			}
			else if(ins.equals("4E"))
			{
				zhujifu = "ORL A,R6";
			}
			else if(ins.equals("4F"))
			{
				zhujifu = "ORL A,R7";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setAssCode(zhujifu);
			disInst.setBinCode(Hex2Binary(ins));
			instslist.add(disInst);
			return insAt;
		}
		
		/** end  һ�ֽ��������Ƿ�������Ӧ�ĺ���**/
		/** begin  ���ֽ��������Ƿ�������Ӧ�ĺ���**/
		

		/**begin ���ֽ��������Ƿ���Ӧ����**/
	
		private int ACALL(int insAt) //xxx10001  xxxxxxxx   �����ӳ������,��ı��ַ
		{
			//A10 A9 A8 1 0 0 0 1     A7 A6 A5 A4 A3 A2 A1 A0
			/**˵����
			 * ACALLָ��ʵ������������λ��addr11��������ʾ��ַ�������̡�
			 * ��ִ�и�ָ��ʱ�����Ƚ�PC��ֵ����2����ʹ��PCָ��ACALL����һ��ָ�
			 * Ȼ���16λPC�ĵ�8λ�͸�8λ����ѹ��ջ��ͬʱ��ջָ�����μ�1.
			 * Ȼ�󣬰ѵ�ǰPCֵ�ĸ�5λ��ACALLָ���һ�ֽڵ�7~5λ�͵�2�ֽ����������
			 * PC:xxxxxxxx xxxxxxxx   DATA xxxxxxxx
			 *    01234567 89abcdef        01234567
			 *    ccccc->��5λ			   76543210  λ��
			 * �õ�һ��16λĿ�ĵ�ַ���õ�ַ��Ϊ�������õ������̵���ڵ�ַ��
			 * Ҫ��������̵���ʼ��ַ���������ACALL֮���ָ���ͬ1��2KB�ĳ���洢ҳ�С�
			 * ACALLָ����ִ��ʱ����ı������־λ��**/
			String PC = address_list.get(insAt);
			PassAdrs.put(PC, true);
			String bits1 = data_inaddress_list.get(insAt++);//��ǰ������   ����+1
			String bits2 = data_inaddress_list.get(insAt);//�����ŵ����� ����+1  ָ����һ��    ��ǰ��ַ��Ҫѹ��ջ��
			PassAdrs.put(address_list.get(insAt++), true);
			String address = PC;
			String ins = bits1;
			String zhujifu = "ACALL ";
			String myargs = bits2;
			String addr = "";
			PC = AddressAddNum(PC, 2);//PC+2;
			addBlockHead(PC);
			//pushinsAt(insAt);
			push(PC);
			addr = Hex2Binary(PC).substring(0,5) 		//��5λ
				 + Hex2Binary(bits1).substring(0,3)		//7-5λ
				 + Hex2Binary(bits2);					//�ڶ��ֽ�
			addr = Binary2Hex(addr);
			addBlockHead(addr);
			zhujifu = zhujifu +addr;
			push(addr);
			AddToFunCalladdr(addr);
			AddToDisInst(address, ins, zhujifu, myargs);
			insAt = pop();
			return insAt;
		}
		
		private int AJMP(int insAt) // xxx00001  xxxxxxxx   ����ת�� ��ı��ַ  �����ǵ�ַת����acallһ������
		{
			String PC = address_list.get(insAt);
			PassAdrs.put(PC, true);
			String bits1 = data_inaddress_list.get(insAt++);//��ǰ������   ����+1
			String bits2 = data_inaddress_list.get(insAt);
			PassAdrs.put(address_list.get(insAt++), true);//�����ŵ����� ����+1  ָ����һ��    ��ǰ��ַ��Ҫѹ��ջ��
			//pushinsAt(insAt);
			String address = PC;
			String ins = bits1;
			String zhujifu = "AJMP ";
			String myargs = bits2;
			String addr = "";
			PC = AddressAddNum(PC, 2);//PC+2;
			//push(PC);
			AddToFunCalladdr(PC);
			addr = Hex2Binary(PC).substring(0,5) 		//��5λ
				 + Hex2Binary(bits1).substring(0,3)		//7-5λ
				 + Hex2Binary(bits2);					//�ڶ��ֽ�
			addr = Binary2Hex(addr);
			AddToFunCalladdr(addr);
			addBlockHead(addr);
			zhujifu = zhujifu +addr;
			push(addr);
			AddToDisInst(address, ins, zhujifu, myargs);
			insAt = pop();
			return insAt;
		}
	
		/***���� �� add�ĵ�ַ��ô��****/
		private int ADD2(int insAt)	//25     ֱ���ֽڼӵ�A 24 �������ӵ�A   ���ֽ�
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt); 
			PassAdrs.put(argsadr, true);
			String myargs = data_inaddress_list.get(insAt++);
			String zhujifu = "ADD A,";
			////add�ĵ�ַת��
			if(ins.equals("25"))
			{
				//add A,address
//				myargs = FindAddr(address, myargs);//ֱ����ƴ�ӵ�ַ
//				PassAdr(myargs);
				zhujifu = zhujifu+myargs;
			}
			else if(ins.equals("24"))
			{
				zhujifu = zhujifu + "#"+myargs;
			}
			AddToDisInst(address, ins, zhujifu, myargs);
			return insAt;
		}
		private int ADDC2(int insAt)	//35     ֱ���ֽڴ���λ�ӵ�A 34 ����������λ�ӵ�A   ���ֽ�
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsaddr =address_list.get(insAt);
			PassAdrs.put(argsaddr, true);
			String myargs = data_inaddress_list.get(insAt++);
			String zhujifu = "ADDC A,";
			////��ַת��
			if(ins.equals("35"))
			{
//				myargs = FindAddr(address, myargs);
//				PassAdr(myargs);
				zhujifu = zhujifu+myargs;
			}
			else if(ins.equals("34"))
			{
				zhujifu = zhujifu + "#"+myargs;
			}
			AddToDisInst(address, ins, zhujifu, myargs);
			return insAt;
		}
		
		/***���� ��bit�ĵ�ַ��ô��****/
		private int ANL2(int insAt)  //55 54 ֱ���ֽ� �������뵽A  52A�뵽ֱ���ֽ�  82 ֱ��λ�뵽��λλ   B0ֱ��λ�ķ����뵽��λλ
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsaddress = address_list.get(insAt);
			PassAdrs.put(argsaddress, true);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("55"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "ANL A,"+args;
			}
			else if(ins.equals("54"))
			{
				zhujifu = "ANL A,#"+args;
			}else if(ins.equals("52"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "ANL "+args+",A";
			}else if(ins.equals("82"))
			{
				PassAdr(args);
				zhujifu = "ANL C,"+args;//ANL C,bit;
			}
			else if(ins.equals("B0"))
			{
				zhujifu = "ANL C,/"+args;//ANL C,/bit;
			} 
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		private int CLR2(int insAt) //C2    ֱ��λ����
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdrs.put(argsadr, true);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "CLR "+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}

		private int CPL2(int insAt) //B2 ֱ��λȡ��
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdrs.put(argsadr, true);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "CPL "+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		/**����*DEC ��ֱ��Ѱַ��  ��ַ�ļ��㷽ʽ����**/
		private int DEC2(int insAt)   //15ֱ���ֽڼ�1
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdrs.put(argsadr, true);
			String args = data_inaddress_list.get(insAt++);
//			args = FindAddr(address, args);
//			PassAdr(args);
			String zhujifu = "DEC "+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		
		/**���� ��ע���ַ��ת**/
		private int DJNZ2(int insAt) //D8-DF  �Ĵ�����1��Ϊ0ת��
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdrs.put(argsadr, true);
			String args = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 2);
			String jadr = JumpAddressAdd(pc, args);//��Ҫ��ת�ĵ�ַ���������뵽ջ��
			//pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			String zhujifu = "";
			//String args1 = args;
			args = jadr;
			if(ins.equals("D8"))
			{
				zhujifu = "DJNZ R0,"+args;
			}
			else if(ins.equals("D9"))
			{
				zhujifu = "DJNZ R1,"+args;
			}
			else if(ins.equals("DA"))
			{
				zhujifu = "DJNZ R2,"+args;
			}
			else if(ins.equals("DB"))
			{
				zhujifu = "DJNZ R3,"+args;
			}
			else if(ins.equals("DC"))
			{
				zhujifu = "DJNZ R4,"+args;
			}
			else if(ins.equals("DD"))
			{
				zhujifu = "DJNZ R5,"+args;
			}
			else if(ins.equals("DE"))
			{
				zhujifu = "DJNZ R6,"+args;
			}
			else if(ins.equals("DF"))
			{
				zhujifu = "DJNZ R7,"+args;
			} 
			//args = args1;
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}
		
		private int INC2(int insAt) //05 ֱ���ֽڼ�1
		{
			String address = address_list.get(insAt);
			PassAdrs.put(address, true);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdrs.put(argsadr, true);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args = FindAddr(address, args);
//			PassAdr(args);
			zhujifu = "INC "+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}

		private int JC2(int insAt) //40  c=1 ת��
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 2);
			String jadr = JumpAddressAdd(pc, args);
			//pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			String zhujifu = "JC "+jadr;
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}

		private int JNC2(int insAt) //50 c==0ת��
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 2);
			String jadr = JumpAddressAdd(pc, args);
			//pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			String zhujifu = "JNC "+jadr;
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}

		private int JNZ2(int insAt) //70 A!=0 ת��
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 2);
			String jadr = JumpAddressAdd(pc, args);
			//pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			String zhujifu = "JNZ "+jadr;
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}
		
		private int JZ2(int insAt)//60 A=0 ת��
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 2);
			String jadr = JumpAddressAdd(pc, args);
			//pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			String zhujifu = "JZ "+jadr;
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}

	
		private int ORL2(int insAt) //42 44 45 ,72, A0  
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("42"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "ORL "+args+",A";
			}
			else if(ins.equals("44"))
			{
				zhujifu = "ORL A,#"+args;
			}
			else if(ins.equals("45"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "ORL A,"+args;
				//String adr = ZHIJIEZIAddress(argsadr, args);
				//AddDataToDisInst(adr);
			}
			else if(ins.equals("72"))	//	λ
			{
				zhujifu = "ORL C,"+args;
			}
			else if(ins.equals("A0"))
			{
				zhujifu = "ORL C,/"+args;
			}
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		private int POP2(int insAt) //D0
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args = FindAddr(address, args);
//			PassAdr(args);
			zhujifu = "POP "+args;//args sp���������͸�args
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		private int PUSH2(int insAt) //C0
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args = FindAddr(address, args);
//			PassAdr(args);
			zhujifu = "PUSH "+args;//args Ӧ���ǰ��������͸�sp
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		private int SETB2(int insAt) //D2
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			zhujifu = "SETB "+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		private int SJMP2(int insAt) //  80  ��ת��     ���е�ַ��ת  
		{
			String address = address_list.get(insAt);
			String PC = address;
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			zhujifu = "SJMP "+args;
			PC = AddressAddNum(PC, 2);
			String offset = args;
			String jadr = JumpAddressAdd(PC, offset);
		//	pushinsAt(insAt);
			push(PC);
			push(jadr);
			addBlockHead(jadr);
			
			AddToDisInst(address, ins, zhujifu, args);
			insAt = pop();
			return insAt;
		}
		private int SUBB2(int insAt) //95 94 ��ȥ�ֽ�/�������ͽ�λ
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("94"))
			{
				zhujifu =  "SUBB A,#"+args;
			}
			else if(ins.equals("95"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "SUBB A,"+args;
				
			}
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		private int XCH2(int insAt) //		C5
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args = FindAddr(address, args);
//			PassAdr(args);
			zhujifu = "XCH A,"+args;
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		/////////����
		private int XRL1(int insAt) //66 -6F  ����������ֱ�������A
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt);//.toUpperCase();//ȫ�����Ǵ�д
			String zhujifu = "";
			if(ins.equals("66"))
			{
				zhujifu = "XRL A,@R0";
			}
			else if(ins.equals("67"))
			{
				zhujifu = "XRL A,@R1";//�����ɻ�
			}
			else if(ins.equals("68"))
			{
				zhujifu = "XRL A,R0";
			}else if(ins.equals("69"))
			{
				zhujifu = "XRL A,R1";
			}else if(ins.equals("6A"))
			{
				zhujifu = "XRL A,R2";
			}else if(ins.equals("6B"))
			{
				zhujifu = "XRL A,R3";
			}else if(ins.equals("6C"))
			{
				zhujifu = "XRL A,R4";
			}else if(ins.equals("6D"))
			{
				zhujifu = "XRL A,R5";
			}else if(ins.equals("6E"))
			{
				zhujifu = "XRL A,R6";
			}else if(ins.equals("6F"))
			{
				zhujifu = "XRL A,R7";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			insAt++;
			PassAdrs.put(address, true);
			return insAt;
		}
		private int XRL2(int insAt) //62  64 65 
		{
			String address = address_list.get(insAt);
			String ins = data_inaddress_list.get(insAt++);
			PassAdr(address);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("64"))
			{
				zhujifu =  "XRL A,#"+args;//"XRL A,#data";
			}
			else if(ins.equals("65"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "XRL A,"+args;//"XRL A,data"
			}
			else if(ins.equals("62"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "XRL "+args+",A";//
			}
			
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		
		/**end  ���ֽڽ���********************************************/
		/**begin  ���ֽڽ���********************************************/
		
		
		private int ANL3(int insAt) //53//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args1 = FindAddr(address, args1);
//			PassAdr(args1);
			zhujifu = "ANL "+args1+",#"+args2;
			AddToDisInst(address, ins, zhujifu, args1, args2);
			return insAt;
		}
		private int CJNE3(int insAt) //B4  - BF//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			String pc = AddressAddNum(address, 3);
			String jadr = JumpAddressAdd(pc, args2);
		//	pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			if(ins.equals("B4"))
			{
				zhujifu = "CJNE A,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("B5"))
			{
//				args1 = FindAddr(address, args1);
//				PassAdr(args1);
				zhujifu =  "CJNE A,"+args1+","+jadr;//args2;
			}
			else if(ins.equals("B6"))
			{
				zhujifu =  "CJNE @R0,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("B7"))
			{
				zhujifu =  "CJNE @R1,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("B8"))
			{
				zhujifu =  "CJNE R0,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("B9"))
			{
				zhujifu =  "CJNE R1,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BA"))
			{
				zhujifu =  "CJNE R2,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BB"))
			{
				zhujifu =  "CJNE R3,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BC"))
			{
				zhujifu =  "CJNE R4,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BD"))
			{
				zhujifu =  "CJNE R5,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BE"))
			{
				zhujifu =  "CJNE R6,#"+args1+","+jadr;//args2;
			}
			else if(ins.equals("BF"))
			{
				zhujifu =  "CJNE R7,#"+args1+","+jadr;//args2;
			}
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}
		
		private int DJNZ3(int insAt) //D5//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			String pc = AddressAddNum(address, 3);
			String jadr = JumpAddressAdd(pc, args2);
			zhujifu = "DJNZ "+args1+","+jadr;
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}
		private int JB3(int insAt) //20  10//
		{
			String address = address_list.get(insAt);
			String pc = address;
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			pc = AddressAddNum(pc, 3);
			String jadr = JumpAddressAdd(pc, args2);
		//	pushinsAt(insAt);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			if(ins.equals("20"))
			{
				zhujifu = "JB "+args1+","+jadr;
			}
			else if(ins.equals("10"))
			{
				zhujifu = "JBC "+args1+","+jadr;
			}
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}
		
		
		private int JNB3(int insAt) //30//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			String pc = AddressAddNum(address, 3);
			String jadr = JumpAddressAdd(pc, args2);
			addBlockHead(pc);
			addBlockHead(jadr);
			push(pc);
			push(jadr);
			zhujifu = "JNB "+args1+","+jadr;
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}
		
		
		private int LCALL3(int insAt) //12//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			String PC = address_list.get(insAt);
			String jadr = args1+args2;
			zhujifu = "LCALL "+jadr;
			addBlockHead(PC);
			addBlockHead(jadr);
			push(PC);
			push(jadr);
			AddToFunCalladdr(jadr);
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}
		
		private int LJMP3(int insAt) //02//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String pc = AddressAddNum(address, 3);
			push(pc);
			String zhujifu = "";
			String jadr = args1+args2;
			addBlockHead(jadr);
			zhujifu = "LJMP "+jadr;
		//	pushinsAt(insAt);
			push(jadr);
			//AddToFunCalladdr(jadr);
			AddToDisInst(address, ins, zhujifu, args1, args2);
			insAt = pop();
			return insAt;
		}

		private int ORL3(int insAt) //43//
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
//			args1 = FindAddr(address, args1);
//			PassAdr(args1);
			String zhujifu = "ORL "+args1+"��#"+args2;//ORL direct��#data
			
			AddToDisInst(address, ins, zhujifu, args1, args2);
			
			return insAt;
		}
		private int XRL3(int insAt) //  63   //
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
//			args1 = FindAddr(address, args1);
//			PassAdr(args1);
			zhujifu = "XRL "+args1+",#"+args2;
			
			AddToDisInst(address, ins, zhujifu, args1, args2);
			return insAt;
		}
		
		/**END ���ֽ�******/
		/****���� 1�ֽ�***/
		
		private int JMP1(int insAt)//73    ��֪����δ�����û��ѹ��ת��ַջ
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String zhujifu = "JMP @A+DPTR";
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			return insAt;
		}

		/**E6-EF   F6-FF   83  93  E2 E3 E0 F2 F3 F0**/
		private int MOV1(int insAt)
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("E6"))
			{
				zhujifu = "MOV A,@R0";
			}
			else if(ins.equals("E7"))
			{
				zhujifu = "MOV A,@R1";
			}
			else if(ins.equals("E8"))
			{
				zhujifu = "MOV A,R0";
			}
			else if(ins.equals("E9"))
			{
				zhujifu = "MOV A,R1";
			}
			else if(ins.equals("EA"))
			{
				zhujifu = "MOV A,R2";
			}
			else if(ins.equals("EB"))
			{
				zhujifu = "MOV A,R3";
			}
			else if(ins.equals("EC"))
			{
				zhujifu = "MOV A,R4";
			}
			else if(ins.equals("ED"))
			{
				zhujifu = "MOV A,R5";
			}
			else if(ins.equals("EE"))
			{
				zhujifu = "MOV A,R6";
			}
			else if(ins.equals("EF"))
			{
				zhujifu = "MOV A,R7";
			}
			else if(ins.equals("F6"))
			{
				zhujifu = "MOV @R0,A";
			}
			else if(ins.equals("F7"))
			{
				zhujifu = "MOV @R1,A";
			}
			else if(ins.equals("F8"))
			{
				zhujifu = "MOV R0,A";
			}
			else if(ins.equals("F9"))
			{
				zhujifu = "MOV R1,A";
			}
			else if(ins.equals("FA"))
			{
				zhujifu = "MOV R2,A";
			}
			else if(ins.equals("FB"))
			{
				zhujifu = "MOV R3,A";
			}
			else if(ins.equals("FC"))
			{
				zhujifu = "MOV R4,A";
			}
			else if(ins.equals("FD"))
			{
				zhujifu = "MOV R5,A";
			}
			else if(ins.equals("FE"))
			{
				zhujifu = "MOV R6,A";
			}
			else if(ins.equals("FF"))
			{
				zhujifu = "MOV R7,A";
			}
			else if(ins.equals("93"))
			{
				zhujifu = "MOVC A,@A+DPTR";
			}
			else if(ins.equals("83"))
			{
				zhujifu = "MOVC A,@A+PC";
			}
			else if(ins.equals("E2"))
			{
				zhujifu = "MOVX A,@R0";
			}
			else if(ins.equals("E3"))
			{
				zhujifu = "MOVX A,@R1";
			}
			else if(ins.equals("E0"))
			{
				zhujifu = "MOVX A,@DPTR";
			}
			else if(ins.equals("F2"))
			{
				zhujifu = "MOVX @R0,A";
			}
			else if(ins.equals("F3"))
			{
				zhujifu = "MOVX @R1,A";
			}
			else if(ins.equals("F0"))
			{
				zhujifu = "MOVX @DPTR,A";
			}
			DisInst disInst = new DisInst();
			disInst.setAddr(address);
			disInst.setBinCode(Hex2Binary(ins));
			disInst.setAssCode(zhujifu);
			instslist.add(disInst);
			return insAt;
		}
		/****/
		/**E5 74  A6-AF  76-7F  F5  86-8F  A2 92 **/
		private int MOV2(int insAt)
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String argsadr = address_list.get(insAt);
			PassAdr(argsadr);
			String args = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("E5"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV A,"+args;
			}
			else if(ins.equals("74"))
			{
				zhujifu = "MOV A,#"+args;
			}
			else if(ins.equals("A6"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV @R0,"+args;
			}
			else if(ins.equals("A7"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV @R0,"+args;
			}
			else if(ins.equals("A8"))
			{	
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R0,"+args;
			}
			else if(ins.equals("A9"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R1,"+args;
			}
			else if(ins.equals("AA"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R2,"+args;
			}
			else if(ins.equals("AB"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R3,"+args;
			}
			else if(ins.equals("AC"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R4,"+args;
			}
			else if(ins.equals("AD"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R5,"+args;
			}
			else if(ins.equals("AE"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R6,"+args;
			}
			else if(ins.equals("AF"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV R7,"+args;
			}
			else if(ins.equals("76"))
			{
				zhujifu = "MOV @R0,#"+args;
			}
			else if(ins.equals("77"))
			{
				zhujifu = "MOV @R1,#"+args;
			}
			else if(ins.equals("78"))
			{
				zhujifu = "MOV R0,#"+args;
			}
			else if(ins.equals("79"))
			{
				zhujifu = "MOV R1,#"+args;
			}
			else if(ins.equals("7A"))
			{
				zhujifu = "MOV R2,#"+args;
			}
			else if(ins.equals("7B"))
			{
				zhujifu = "MOV R3,#"+args;
			}
			else if(ins.equals("7C"))
			{
				zhujifu = "MOV R4,#"+args;
			}
			else if(ins.equals("7D"))
			{
				zhujifu = "MOV R5,#"+args;
			}
			else if(ins.equals("7E"))
			{
				zhujifu = "MOV R6,#"+args;
			}
			else if(ins.equals("7F"))
			{
				zhujifu = "MOV R7,#"+args;
			}
			else if(ins.equals("F5")) 
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",A";
			}
			else if(ins.equals("86"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",@R0";
			}
			else if(ins.equals("87"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",@R1";
			}
			else if(ins.equals("88"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R0";
			}
			else if(ins.equals("89"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R1";
			}
			else if(ins.equals("8A"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R2";
			}
			else if(ins.equals("8B"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R3";
			}
			else if(ins.equals("8C"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R4";
			}
			else if(ins.equals("8D"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R5";
			}
			else if(ins.equals("8E"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R6";
			}
			else if(ins.equals("8F"))
			{
//				args = FindAddr(address, args);
//				PassAdr(args);
				zhujifu = "MOV "+args+",R7";
			}
			else if(ins.equals("A2"))
			{
				zhujifu = "MOV C,"+args;
			}
			else if(ins.equals("92"))
			{
				zhujifu = "MOV "+args+",C";
			}
			AddToDisInst(address, ins, zhujifu, args);
			return insAt;
		}
		/**85 75 90**/
		private int MOV3(int insAt)
		{
			String address = address_list.get(insAt);
			PassAdr(address);
			String ins = data_inaddress_list.get(insAt++);
			String args1adr = address_list.get(insAt);
			PassAdr(args1adr);
			String args1 = data_inaddress_list.get(insAt++);
			String args2adr = address_list.get(insAt);
			PassAdr(args2adr);
			String args2 = data_inaddress_list.get(insAt++);
			String zhujifu = "";
			if(ins.equals("85"))
			{
//				args1 = FindAddr(address, args1);
//				PassAdr(args1);
//				args2 = FindAddr(address, args2);
//				PassAdr(args2);
				zhujifu = "MOV "+args1+","+args2;
			}
			else if(ins.equals("75"))
			{
//				args1 = FindAddr(address, args1);
//				PassAdr(args1);
				zhujifu ="MOV "+args1+",#"+args2;
			}
			else if(ins.equals("90"))
			{
				String data = args1+args2;
				zhujifu ="MOV DPTR ,#"+data;
			}
			
			AddToDisInst(address, ins, zhujifu, args1, args2);
			return insAt;
		}
		/***����list����***/
	
		
		/**��ʼ�����������**/
		public void Parser()
		{
			
			/**���ſ�ʼ����addresslist��datalist�е����ݣ�
			 * ����InsMap��hashmap��instlist��dataslist���������**/
			
			if(PIC)
			{
				
			}
			else if(I51)
			{

				parser8051();
				parser_function();
				parserblocks();
			}
		}
		public ArrayList<DisFunction> getFunctionsList()
		{
			return functionslist;
		}
		public ArrayList<DisInst> getInstsList()
		{
			return instslist;
		}
		private void parserFrom_To(int begin,int end)
		{
			int insAt = begin ;
			if(end==-1)
			{
				end = address_list.size();
			}
			while(insAt!=-1&&insAt<end)
			{
				String adr = address_list.get(insAt);//�õ���ǰinsAt�ĵ�ַ
				
				if(PassAdrs.get(adr))//�����ַ������
				{
					DisInst inst = findDisInst(instslist, adr);
					if(inst == null)
					{
						insAt ++;
						
					}
					else{
						insAt = pop();//������  ��������   ���ջ���ó���һ��������ַ
					}
					continue;
				}
				//���û�о���
				String ins = data_inaddress_list.get(insAt);
				if(ins.endsWith("1"))
				{
					String bin = Hex2Binary(ins);
					if(bin.endsWith("10001"))
					{
						insAt = ACALL(insAt);
					}
					else {
						insAt = AJMP(insAt);
					}
				}
				else{
					if(one_bits_ins_list.contains(ins))
					{
						insAt = deal1(ins, insAt);
					}
					else if(two_bits_ins_list.contains(ins))
					{
						insAt = deal2(ins, insAt);
					}
					else if(three_bits_ins_list.contains(ins))
					{
						insAt = deal3(ins, insAt);
					}
				}
			}
		}
		private void parser8051()
		{
			parserFrom_To(0, -1);
			// ������֮��Ҫ��������instslist����
			while(addrNextRet.size()!=0)
			{
				String addr = addrNextRet.get(0);
				addrNextRet.remove(0);
				if(PassAdrs.get(addr))
				{
					continue;
				}
				int insAt = address_list.indexOf(addr);
				parserFrom_To(insAt, -1);
			}

			ArrayList<DisInst> thelist = new ArrayList<DisInst>();
			for (int i = 0; i < address_list.size(); i++) 
			{
				String adr = address_list.get(i);
				if(PassAdrs.get(adr))//��ַ�Ѿ�������
				{
					DisInst disInst = findDisInst(instslist, adr);
					if(disInst == null)//��ʾ�Բ�����ʽ����
					{
						disInst = new DisInst();
						disInst.setAddr(adr);
						disInst.setBinCode(data_inaddress_list.get(i));
						thelist.add(disInst);
					}
					else{//��������ʽ����
						thelist.add(disInst);
					}
				}
				else{
					//δ����
					DisInst disInst = new DisInst();
					disInst.setAddr(adr);
					disInst.setBinCode(Hex2Binary(data_inaddress_list.get(i)));
					thelist.add(disInst);
				}
			}
			instslist = thelist;
		}
		//�ҵ���ַ��Ӧ����������λ��


		private boolean DisInstisReturn(DisInst start)
		{
			boolean isok = false;
			String bin = start.getBinCode();
			String op = start.getAssCode();
			if(op.equals(""))
			{
				return false;
			}
			else
			{
				String hex = Binary2Hex(bin);
				if(hex.equals("22"))
				{
					isok = true;
				}
			}
			return isok;
		}
		//����������
		
		private Map<String,String> FunFirstAddr_Name = new HashMap<String,String>();
		public Map<String,String> getFun_NameMap()
		{
			return FunFirstAddr_Name;
		}
		private ArrayList<String> paixu(ArrayList<String> list)
		{
			for (int i = 0; i < list.size(); i++) 
			{
				for (int j = 0; j < list.size()-1-i; j++) 
				{
					if(a_dayu_b(list.get(j), list.get(j+1)))
					{
						String temp = list.get(j);
						list.set(j, list.get(j+1));
						list.set(j+1, temp);
					}
				}
			}
			return list;
		}
		private void parser_function()
		{
			funcalladdresses = paixu(funcalladdresses);
			int funAT = 0;
			int funcount = 0;
			while(funAT<funcalladdresses.size())
			{
				String funadr = funcalladdresses.get(funAT);
				int funadrbegin = address_list.indexOf(funadr);//�ҵ��������
				int funadrend = -1;
				boolean funisok = false;
				for (int i = funadrbegin; i < instslist.size(); i++) 
				{
					DisInst disInst = instslist.get(i);//��������ҳ������б������ 
					funadr = disInst.getAddr();
					if(Funadrpass.get(funadr))//Ϊ���ʾ������
					{
						break;
					}
					
					
					if(DisInstisReturn(disInst))//�����ret����
					{
						//System.out.println("Ret����");
						funadrend = i;
						funisok = true;
						Funadrpass.put(disInst.getAddr(), true);
						if((i+1)<instslist.size())
						{	
							disInst = instslist.get(i+1);
							if(funcalladdresses.contains(disInst.getAddr()))
							{
								break;
							}
							else{
								continue;
							}
						}
						else{
							break;
						}
					}
					//������ret
					Funadrpass.put(disInst.getAddr(), true);
				}
				if(funisok)
				{
					DisFunction disFunction = new DisFunction();
					String funname = "Fun_"+funcount;
					DisInst inst = instslist.get(funadrbegin);
					String funaddr = inst.getAddr();
					funcount++;
					disFunction.setFunctionAddr(funaddr);
					disFunction.setFunctionName(funname);
					disFunction.setStart(funadrbegin);
					disFunction.setEnd(funadrend);
					for (int i = funadrbegin; i <= funadrend; i++) {
						disFunction.addInstruction(instslist.get(i));
					}
					functionslist.add(disFunction);
					
				}
					funAT++;
			}
			
		}
		
		/**
		 * ��ʼ���ֻ�����
		 **/
		private boolean IstwobitsJmpINS(DisInst inst)
		{
			if(inst.getAssCode().equals(""))
			{
				return false;
			}
			boolean yes = false;
			String bin = inst.getBinCode();
			String hex = Binary2Hex(bin);
			if(HEXbetween(hex, "D8", "DF")||hex.equals("40")||hex.equals("50")||hex.equals("60")||hex.equals("70"))
			{
				yes = true;
			}
			return yes;
		}
		private boolean IsINS(DisInst inst)
		{
			if(inst.getAssCode().equals(""))
			{
				return false;
			}
			return true;
		}
		private boolean IsthreebitsJmpINS(DisInst inst)
		{
			if(inst.getAssCode().equals(""))
			{
				return false;
			}
			boolean yes = false;
			String bin = inst.getBinCode();
			String hex = Binary2Hex(bin);
			if(hex.equals("D5")||hex.equals("10")||hex.equals("20")||hex.equals("30")
					||HEXbetween(hex, "B4", "BF"))
			{
				yes = true;
			}
			return yes;
		}
		private DisFunction parser_block(DisFunction function)
		{
			ArrayList<String> headlist = block_head_address;
			ArrayList<DisInst> funinslist = function.getInstructionList();
			int funAt = 0;
	 		while(funAt<funinslist.size())
	 		{
	 			int perbegin = 0;
	 			int begin = funAt;
	 			int blockhead = -1;
	 			int blockend = -1;
	 			while(begin<funinslist.size())
	 			{
	 				DisInst inst = funinslist.get(begin);
	 				if(IsINS(inst))
	 				{
	 					
	 					if(headlist.contains(inst.getAddr()))
	 					{
	 						inst.setHead();
	 						if(blockhead==-1)
	 						{
	 							blockhead = begin;
	 							begin++;
	 							continue;
	 						}
	 						else{
	 							perbegin = begin;
	 							while(perbegin>0)
	 							{
	 								perbegin--;
	 								if(IsINS(funinslist.get(perbegin)))
	 								{
	 									break;
	 								}
	 							}
	 							blockend = perbegin;
	 							break;
	 						}
	 					}
	 					else{
	 						begin++;
	 						continue;
	 					}
	 				}
	 				else 
	 				{
	 					begin++;
	 				}
	 				
	 			}
	 			funAt = begin;
	 			if(blockhead!=-1&&blockend==-1)
	 			{
	 				blockend = funinslist.size()-1;
	 			}
	 			DisBlock block = new DisBlock();
	 			block.setStart(blockhead);
	 			block.setEnd(blockend);
	 			block.setStartAddr(funinslist.get(blockhead).getAddr());
	 			function.addBlock(block);
	 		}
	 		function = find_PerAndNext_block(function);
	 		return function;
		}
		private void parserblocks()
		{
			for (int i = 0; i < functionslist.size(); i++) {
				DisFunction function = functionslist.get(i);
				function = parser_block(function);
				functionslist.set(i, function);
			}
			
		}
		/**
		 * �������ֻ�����
		 **/
		/**
		 *	��		��		��		ͼ	 
		 * **/
		private int findBlockIndexByAddress_num(ArrayList<DisBlock> blocklist,int address)
		{
			int index = -1;
			for (int i = 0; i < blocklist.size(); i++) {
				DisBlock block = blocklist.get(i);
				if(address>=block.getStart()&&address<=block.getEnd())
				{
					index = i;
				}
			}
			return index;
		}
		private int findINSindexByAddress(ArrayList<DisInst> inslist,String jadr)
		{
			int index =-1;
			for (int i = 0; i < inslist.size(); i++) {
				DisInst inst = inslist.get(i);
				if(inst.getAddr().equals(jadr))
				{
					index = i;
				}
			}
			return index;
		}
		private DisFunction find_PerAndNext_block(DisFunction function)
		{
			ArrayList<DisBlock> blocklist = function.getBlocklist();
			ArrayList<DisInst> inslist = function.getInstructionList();
			for (int i = 0; i < blocklist.size(); i++) 
			{
				DisBlock blockfather = blocklist.get(i);
				int last = blockfather.getEnd();
				DisInst inst = inslist.get(last);
				if(IsthreebitsJmpINS(inst))//3�ֽ�
				{
					String pc = inst.getAddr();
					String nextpc = AddressAddNum(pc, 3);
					int nextpcnum = last+3;
					int blocknum = findBlockIndexByAddress_num(blocklist, nextpcnum);
					DisBlock blockson1 = blocklist.get(blocknum);
					blockfather.addSubBlockIndex(blocknum);
					blockson1.addPreBlockIndex(i);
					String offset = inslist.get(last+2).getBinCode();
					String jadr = JumpAddressAdd(nextpc, offset);
					int jadrnum = findINSindexByAddress(inslist, jadr);
					if(jadrnum!=-1)
					{
						int jadrATblocknum = findBlockIndexByAddress_num(blocklist, jadrnum);
						if(jadrATblocknum!=-1)
						{
							DisBlock blockson2 = blocklist.get(jadrATblocknum);
							blockfather.addSubBlockIndex(jadrATblocknum);
							blockson2.addPreBlockIndex(i);
						}
					}
				}
				else if(IstwobitsJmpINS(inst))//2�ֽ�
				{
					String pc = inst.getAddr();
					String nextpc = AddressAddNum(pc, 2);
					int nextpcnum = last+2;
					int blocknum = findBlockIndexByAddress_num(blocklist, nextpcnum);
					DisBlock blockson1 = blocklist.get(blocknum);
					blockfather.addSubBlockIndex(blocknum);
					blockson1.addPreBlockIndex(i);
					String offset = inslist.get(last+1).getBinCode();
					String jadr = JumpAddressAdd(nextpc, offset);
					int jadrnum = findINSindexByAddress(inslist, jadr);
					if(jadrnum!=-1)
					{
						int jadrATblocknum = findBlockIndexByAddress_num(blocklist, jadrnum);
//						System.out.print(function.getFunctionName()+" "+function.getFunctionAddr());
//						System.out.println(" addr="+jadr+" "+jadrATblocknum+" blocklist_size="+blocklist.size());
						if(jadrATblocknum!=-1)
						{
							DisBlock blockson2 = blocklist.get(jadrATblocknum);
							blockfather.addSubBlockIndex(jadrATblocknum);
							blockson2.addPreBlockIndex(i);
						}
					}
				}
			}
			return function;
		}
		/**
		 *	��		��		��		ͼ	 
		 * **/
		
	    /************************************************************
		****                                                     ****
		****     PPPPPPPPP         IIIIIIIIII         CCCCCCCC   ****
		****     PP      PP            II           CC       CC  ****
		****     PP      PP            II          CC            ****
		****     PPPPPPPPP             II          CC            ****
		****     PP                    II          CC            ****
		****     PP                    II          CC            ****
		****     PP                    II          CC            ****
		****     PP                    II           CC       CC  ****
		****     PP                IIIIIIIIII         CCCCCCCC   ****
		****                                                     ****
		************************************************************/
		private ArrayList<String> picaddress = null;//address_list;		PIC��ַ����
		private ArrayList<String> picdata = null;//data_inaddress_list;	PIC��������
		private ArrayList<DisInst> picinstslist = new ArrayList<DisInst>();
		private Map<String, Boolean> picpassadrs = null;//PassAdrs; 	ָ����ĵ�ַ
		private void PICaddpassaddr(String address)		//��Ӿ����ĵ�ַ
		{
			if(!picpassadrs.containsKey(address))
			{
				picpassadrs.put(address, true);
			}
		}
		//AddToDisInst(address, ins, zhujifu, args);
		
		private int PIC_ins_lengh = 0;//PIC ָ���
		private String picarraylistToBinaryString(ArrayList<String> list)//�������ݱ�ɶ�����
		{
			String ret = "";
			for (int i = 0; i < list.size(); i++) {
				ret = ret+Hex2Binary(list.get(i));
			}
			return ret;
		}
		private void picparserfrom(int from,int end)
		{
			if(end == -1)
			{
				end = picaddress.size();
			}
			int insAt=0;
			insAt = from;
			while(insAt<end)
			{
				ArrayList<String> tempinsaddr = new ArrayList<String>();
				ArrayList<String> tempinsdata = new ArrayList<String>();
				for (int i = 0; i < PIC_ins_lengh; i++) 
				{
					String adr = picaddress.get(insAt+i).toUpperCase();
					String dat = picdata.get(insAt+i).toUpperCase();
					tempinsaddr.add(adr);
					PICaddpassaddr(adr);
					tempinsdata.add(dat);
				}
				String ins = picarraylistToBinaryString(tempinsdata);
			}
		}
		private void parserPIC(int picinslen)
		{
			PIC_ins_lengh = picinslen;
			picaddress = address_list;
			picdata = data_inaddress_list;
			picpassadrs = PassAdrs;
		}
		
		
}
