package com.damianfanaro.anki.game.event;

import com.damianfanaro.anki.box.Box;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class BoxSelectedEvent {

    private final String id;
    private final Box selectedBox;

}
