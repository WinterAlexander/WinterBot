package me.winter.ai.word;

import me.winter.ai.EnglishUtil;

/**
 *
 * Created by Alexander Winter on 2015_12_01.
 */
public enum IrregularVerb implements Verb
{
	ARISE("arise", "arose", "arisen"),
	AWAKE("awake", "awoke", "awoken"),
	BE("be", "was/were", "been")
			{
				@Override
				public String conjugate(VerbTense tense, ConjugationType type, int person, String subject)
				{
					return super.conjugate(tense, type, person, subject).replace("been being", "been");
				}

				@Override
				public String getBaseForm(int person)
				{
					switch(person)
					{
						case 1:
							return "am";

						case 2:
						case 4:
						case 5:
						case 6:
							return "are";

						case 3:
							return "is";

						default:
							return "be";
					}
				}

				@Override
				public String getPastForm(int person)
				{
					switch(person)
					{
						case 1:
						case 3:
							return "was";

						case 2:
						case 4:
						case 5:
						case 6:
							return "were";

						default:
							return "be";
					}
				}

				@Override
				public String getIngForm()
				{
					return "being";
				}
			},
	BEAR("bear", "bore", "borne"),
	BEAT("beat", "beat", "beaten"),
	BECOME("become", "became", "become"),
	BEGIN("begin", "began", "begun"),
	BEND("bend", "bent", "bent"),
	BESET("beset", "beset", "beset"),
	BET("bet", "bet/betted", "bet"),
	BID("bid", "bid", "bid"),
	BIND("bind", "bound", "bound"),
	BITE("bite", "bit", "bitten"),
	BLEED("bleed", "bled", "bled"),
	BLOW("blow", "blew", "blown"),
	BREAK("break", "broke", "broken"),
	BREED("breed", "bred", "bred"),
	BRING("bring", "brought", "brought"),
	BROADCAST("broadcast", "broadcast", "broadcast"),
	BUILD("build", "built", "built"),
	BURN("burn", "burnt/burned", "burnt/burned"),
	BURST("burst", "burst", "burst"),
	BUY("buy", "bought", "bought"),
	CAST("cast", "cast", "cast"),
	CATCH("catch", "caught", "caught"),
	CHOOSE("choose", "chose", "chosen"),
	CLING("cling", "clung", "clung"),
	COME("come", "came", "come"),
	COST("cost", "cost", "cost"),
	CREEP("creep", "crept", "crept"),
	CUT("cut", "cut", "cut"),
	DEAL("deal", "dealt", "dealt"),
	DIG("dig", "dug", "dug"),
	DIVE("dive", "dived", "dived"),
	DO("do", "did", "done"),
	DRAW("draw", "drew", "drawn"),
	DREAM("dream", "dreamt/dreamed", "dreamt/dreamed"),
	DRINK("drink", "drank", "drunk"),
	DRIVE("drive", "drove", "driven"),
	EAT("eat", "ate", "eaten"),
	FALL("fall", "fell", "fallen"),
	FEED("feed", "fed", "fed"),
	FEEL("feel", "felt", "felt"),
	FIGHT("fight", "fought", "fought"),
	FIND("find", "found", "found"),
	FIT("fit", "fit", "fit"),
	FLEE("flee", "fled", "fled"),
	FLING("fling", "flung", "flung"),
	FLY("fly", "flew", "flown"),
	FORBID("forbid", "forbade", "forbidden"),
	FORGET("forget", "forgot", "forgotten"),
	FOREGO("forego/forgo", "forewent", "foregone"),
	FORGIVE("forgive", "forgave", "forgiven"),
	FORSAKE("forsake", "forsook", "forsaken"),
	FORETELL("foretell", "foretold", "foretold"),
	FREEZE("freeze", "froze", "frozen"),
	GET("get", "got", "got"),
	GIVE("give", "gave", "given"),
	GO("go", "went", "gone"),
	GRIND("grind", "ground", "ground"),
	GROW("grow", "grew", "grown"),
	HANG("hang", "hung", "hung"),
	HANG2("hang", "hanged", "hanged"), //NOT THE SAME MEANING
	HAVE("have", "had", "had")
			{
				@Override
				public String getBaseForm(int person)
				{
					switch(person)
					{
						case 3:
							return "has";
						default:
							return "have";
					}
				}
			},
	HEAR("hear", "heard", "heard"),
	HIDE("hide", "hid", "hidden"),
	HIT("hit", "hit", "hit"),
	HOLD("hold", "held", "held"),
	HURT("hurt", "hurt", "hurt"),
	KEEP("keep", "kept", "kept"),
	KNEEL("kneel", "knelt", "knelt"),
	KNOW("know", "knew", "known"),
	LAY("lay", "laid", "laid"),
	LEAD("lead", "led", "led"),
	LEAN("lean", "leant/leaned", "leant/leaned"),
	LEAP("leap", "leapt/leaped", "leapt/leaped"),
	LEARN("learn", "learnt/learned", "learnt/learned"),
	LEAVE("leave", "left", "left"),
	LEND("lend", "lent", "lent"),
	LET("let", "let", "let"),
	LIE("lie", "lay", "lain"),
	LIGHT("light", "lit/lighted", "lit/lighted"),
	LOSE("lose", "lost", "lost"),
	MAKE("make", "made", "made"),
	MEAN("mean", "meant", "meant"),
	MEET("meet", "met", "met"),
	MISSPELL("misspell", "misspelt/misspelled", "misspelt/misspelled"),
	MISTAKE("mistake", "mistook", "mistaken"),
	MOW("mow", "mowed", "mowed/mown"),
	OVERCOME("overcome", "overcame", "overcome"),
	OVERDO("overdo", "overdid", "overdone"),
	OVERTAKE("overtake", "overtook", "overtaken"),
	OVERTHROW("overthrow", "overthrew", "overthrown"),
	PAY("pay", "paid", "paid"),
	PLEAD("plead", "pleaded/plead", "pleaded/plead"),
	PROVE("prove", "proved", "proved/proven"),
	PUT("put", "put", "put"),
	QUIT("quit", "quit", "quit"),
	READ("read", "read", "read"),
	RID("rid", "rid", "rid"),
	RIDE("ride", "rode", "ridden"),
	RING("ring", "rang", "rung"),
	RISE("rise", "rose", "risen"),
	RUN("run", "ran", "run"),
	SAW("saw", "sawed", "sawn/sawed"),
	SAY("say", "said", "said"),
	SEE("see", "saw", "seen"),
	SEEK("seek", "sought", "sought"),
	SELL("sell", "sold", "sold"),
	SEND("send", "sent", "sent"),
	SET("set", "set", "set"),
	SEW("sew", "sewed", "sewn/sewed"),
	SHAKE("shake", "shook", "shaken"),
	SHEAR("shear", "sheared", "sheared/shorn"),
	SHED("shed", "shed", "shed"),
	SHINE("shine", "shone", "shone"),
	SHOOT("shoot", "shot", "shot"),
	SHOW("show", "showed", "shown"),
	SHRINK("shrink", "shrank", "shrunk"),
	SHUT("shut", "shut", "shut"),
	SING("sing", "sang", "sung"),
	SINK("sink", "sank", "sunk"),
	SIT("sit", "sat", "sat"),
	SLEEP("sleep", "slept", "slept"),
	SLAY("slay", "slew", "slayed/slain"),
	SLIDE("slide", "slid", "slid"),
	SLING("sling", "slung", "slung"),
	SLIT("slit", "slit", "slit"),
	SMELL("smell", "smelt/smelled", "smelt/smelled"),
	SMITE("smite", "smote", "smitten"),
	SOW("sow", "sowed", "sown/sowed"),
	SPEAK("speak", "spoke", "spoken"),
	SPEED("speed", "sped/speeded", "sped/speeded"),
	SPELL("spell", "spelt/spelled", "spelt/spelled"),
	SPEND("spend", "spent", "spent"),
	SPILL("spill", "spilt/spilled", "spilt/spilled"),
	SPIN("spin", "spun", "spun"),
	SPIT("spit", "spat", "spat"),
	SPLIT("split", "split", "split"),
	SPOIL("spoil", "spoilt/spoiled", "spoilt/spoiled"),
	SPREAD("spread", "spread", "spread"),
	SPRING("spring", "sprang", "sprung"),
	STAND("stand", "stood", "stood"),
	STEAL("steal", "stole", "stolen"),
	STICK("stick", "stuck", "stuck"),
	STING("sting", "stung", "stung"),
	STINK("stink", "stank", "stunk"),
	STRIDE("stride", "strode", "stridden"),
	STRIKE("strike", "struck", "struck"),
	STRIVE("strive", "strove", "striven"),
	SWEAR("swear", "swore", "sworn"),
	SWEEP("sweep", "swept", "swept"),
	SWELL("swell", "swelled", "swelled/swollen"),
	SWIM("swim", "swam", "swum"),
	SWING("swing", "swung", "swung"),
	TAKE("take", "took", "taken"),
	TEACH("teach", "taught", "taught"),
	TEAR("tear", "tore", "torn"),
	TELL("tell", "told", "told"),
	THINK("think", "thought", "thought"),
	THRIVE("thrive", "thrived/throve", "thrived"),
	THROW("throw", "threw", "thrown"),
	THRUST("thrust", "thrust", "thrust"),
	TREAD("tread", "trod", "trodden"),
	UNDERSTAND("understand", "understood", "understood"),
	UPHOLD("uphold", "upheld", "upheld"),
	UNDO("undo", "undid", "undone"),
	UPSET("upset", "upset", "upset"),
	WAKE("wake", "woke/waked", "woken/waked"),
	WEAR("wear", "wore", "worn"),
	WEAVE("weave", "wove/weaved", "woven/weaved"),
	WED("wed", "wedded/wed", "wedded/wed"),
	WEEP("weep", "wept", "wept"),
	WIN("win", "won", "won"),
	WIND("wind", "wound", "wound"),
	WITHDRAW("withdraw", "withdrew", "withdrawn"),
	WITHHOLD("withhold", "withheld", "withheld"),
	WITHSTAND("withstand", "withstood", "withstood"),
	WRING("wring", "wrung", "wrung"),
	WRITE("write", "wrote", "written"),

	WAYLAY("waylay", "waylaid", "waylaid"),
	UNDERSPEND("underspend", "underspent", "underspent"),
	OVERSPEND("overspend", "overspent", "overspent"),
	WET("wet", "wet/wetted", "wet/wetted"),
	ABIDE("abide", "abode", "abode"),
	;

	private String[] infinitive, pastSimple, pastParticiple;


	IrregularVerb(String infinitive, String pastSimple, String pastParticiple)
	{
		this(infinitive.split("/"), pastSimple.split("/"), pastParticiple.split("/"));
	}

	IrregularVerb(String[] infinitive, String[] pastSimple, String[] pastParticiple)
	{
		this.infinitive = infinitive;
		this.pastSimple = pastSimple;
		this.pastParticiple = pastParticiple;

		EnglishUtil.toLowerCase(this.infinitive);
		EnglishUtil.toLowerCase(this.pastSimple);
		EnglishUtil.toLowerCase(this.pastParticiple);
	}

	@Override
	public String getInfinitive()
	{
		return infinitive[0];
	}

	@Override
	public String getPastForm(int person)
	{
		return pastSimple[0];
	}

	@Override
	public String getParticiple()
	{
		return pastParticiple[0];
	}
}
