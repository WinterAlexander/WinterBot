package me.winter.ai.word;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public enum VerbTense
{
	SIMPLE_PRESENT(Tense.PRESENT, "%subject; %base;",
			"%subject; %aux:do:base;%not; %inf;",
			"%aux:do:base; %subject; %inf;",
			"%aux:do:base;%not; %subject; %inf;"),
	PRESENT_CONTINUOUS(Tense.PRESENT, "%subject; %aux:be:base; %-ing;",
			"%subject; %aux:be:base;%not; %-ing;",
			"%aux:be:base; %subject; %-ing;",
			"%aux:be:base; %subject;%not; %-ing;"),

	SIMPLE_PAST(Tense.PAST, "%subject; %past;", 
			"%subject; %aux:do:past; %inf;", 
			"%aux:do:past; %subject; %inf;", 
			"%aux:do:past;%not; %subject; %inf;"),
	PAST_CONTINUOUS(Tense.PAST, "%subject; %aux:be:past; %-ing;",
			"%subject; %aux:be:past;%not; %-ing;",
			"%aux:be:past; %subject; %-ing;",
			"%aux:be:past; %subject;%not; %-ing;"),
	PRESENT_PERFECT(Tense.PAST, "%subject; %aux:have:base; %part;",
			"%subject; %aux:have:base;%not; %part;",
			"%aux:have:base; %subject; %part;",
			"%aux:have:base;%not; %subject; %part;"),
	PRESENT_PERFECT_CONTINUOUS(Tense.PAST, "%subject; %aux:have:base; %aux:be:part; %-ing;",
			"%subject; %aux:have:base;%not; %aux:be:part; %-ing;",
			"%aux:have:base; %subject; %aux:be:part; %-ing;",
			"%aux:have:base;%not; %subject; %aux:be:part; %-ing;"),
	PAST_PERFECT(Tense.PAST, "%subject; %aux:have:past; %part;",
			"%subject; %aux:have:past;%not; %part;",
			"%aux:have:past; %subject; %part;",
			"%aux:have:past;%not; %subject; %part;"),
	PAST_PERFECT_CONTINUOUS(Tense.PAST, "%subject; %aux:have:past; %aux:be:part; %-ing;",
			"%subject; %aux:have:past;%not; %aux:be:part; %-ing;",
			"%aux:have:past; %subject; %aux:be:part; %-ing;",
			"%aux:have:past;%not; %subject; %aux:be:part; %-ing;"),

	FUTURE_SIMPLE(Tense.FUTURE, "%subject; %will; %inf;",
			"%subject; %will;%not; %inf;",
			"%will; %subject; %inf;",
			"%will;%not; %subject; %inf;"),
	FUTURE_CONTINUOUS(Tense.FUTURE, "%subject; %will; %aux:be:inf; %-ing;",
			"%subject; %will;%not; %aux:be:inf; %-ing;",
			"%will; %subject; %aux:be:inf; %-ing;",
			"%will;%not; %subject; %aux:be:inf; %-ing;"),
	FUTURE_PERFECT(Tense.FUTURE, "%subject; %will; %aux:have:inf; %part;",
			"%subject; %will;%not; %aux:have:inf; %part;",
			"%will; %subject; %aux:have:inf; %part;",
			"%will;%not; %subject; %aux:have:inf; %part;"),
	FUTURE_PERFECT_CONTINUOUS(Tense.FUTURE, "%subject; %will; %aux:have:inf; %aux:be:part; %-ing;",
			"%subject; %will;%not; %aux:have:inf; %aux:be:part; %-ing;",
			"%will; %subject; %aux:have:inf; %aux:be:part; %-ing;",
			"%will;%not; %subject; %aux:have:inf; %aux:be:part; %-ing;"),
	BEGOINGTO(Tense.FUTURE, "%subject; %aux:be:base; %aux:go:-ing; to %inf;",
			"%subject; %aux:be:base;%not; %aux:go:-ing; to %inf;",
			"%aux:be:base; %subject; %aux:go:-ing; to %inf;",
			"%aux:be:base;%not; %subject; %aux:go:-ing; to %inf;"),
	BEGOINGTO_PERFECT(Tense.FUTURE, "%subject; %aux:be:base; %aux:go:-ing; to %aux:have:inf; %part;",
			"%subject; %aux:be:base;%not; %aux:go:-ing; to %aux:have:inf; %part;",
			"%aux:be:base; %subject; %aux:go:-ing; to %aux:have:inf; %part;",
			"%aux:be:base;%not; %subject; %aux:go:-ing; to %aux:have:inf; %part;"),
	BEGOINGTO_PERFECT_CONTINUOUS(Tense.FUTURE, "%subject; %aux:be:base; %aux:go:-ing; to %aux:have:inf; %aux:be:part; %part;",
			"%subject; %aux:be:base;%not; %aux:go:-ing; to %aux:have:inf; %aux:be:part; %part;",
			"%aux:be:base; %subject; %aux:go:-ing; to %aux:have:inf; %aux:be:part; %part;",
			"%aux:be:base;%not; %subject; %aux:go:-ing; to %aux:have:inf; %aux:be:part; %part;"),

	//TODO MODAL FORMS
	//PRESENT SUBJUNCTIVE
	;

	public static final Pattern codePattern = Pattern.compile("(%[A-Za-z\\-:]{3,};)");

	private Tense tense;
	private Map<ConjugationType, String> forms;

	VerbTense(Tense tense, String affirmative, String negative, String interrogative, String negative_n_interro)
	{
		this.forms = new HashMap<>();
		this.tense = tense;
		this.forms.put(ConjugationType.AFFIRMATIVE, affirmative);
		this.forms.put(ConjugationType.NEGATIVE, negative);
		this.forms.put(ConjugationType.INTERROGATIVE, interrogative);
		this.forms.put(ConjugationType.NEGATIVE_AND_INTERROGATIVE, negative_n_interro);
	}

	public String getForm(ConjugationType type)
	{
		return this.forms.get(type);
	}

	public Tense getTense()
	{
		return tense;
	}
}
