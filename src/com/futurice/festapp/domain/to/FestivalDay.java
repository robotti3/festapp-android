package com.futurice.festapp.domain.to;


import com.futurice.festapp.R;
import android.content.Context;

public enum FestivalDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY,
	MON,
	TUE,
	WED,
	THU,
	FRI,
	SAT,
	SUN;
	
	public String getLocalName(Context context) {
		switch (this) {
        case MONDAY:
            return context.getString(R.string.Monday);
        case TUESDAY:
            return context.getString(R.string.Tuesday);
		case WEDNESDAY:
            return context.getString(R.string.Wednesday);
        case THURSDAY:
            return context.getString(R.string.Thursday);
        case FRIDAY:
			return context.getString(R.string.Friday);
		case SATURDAY:
			return context.getString(R.string.Saturday);
		case SUNDAY:
			return context.getString(R.string.Sunday);
        case MON:
            return context.getString(R.string.Mon);
        case TUE:
            return context.getString(R.string.Tue);
		case WED:
            return context.getString(R.string.Wed);
        case THU:
            return context.getString(R.string.Thu);
        case FRI:
			return context.getString(R.string.Fri);
		case SAT:
			return context.getString(R.string.Sat);
		case SUN:
			return context.getString(R.string.Sun);
		default:
			return null;
		}
	}
	
}
