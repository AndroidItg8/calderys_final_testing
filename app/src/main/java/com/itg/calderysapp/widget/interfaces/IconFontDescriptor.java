package com.itg.calderysapp.widget.interfaces;

public interface IconFontDescriptor {
    /**
     * The TTF file name.
     * @return a name with no slash, present in the assets.
     */
    String ttfFileName();

    Icon[] characters();
}
