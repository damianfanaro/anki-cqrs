package com.damianfanaro.anki.game.event;

import lombok.*;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public final class AnswerShownEvent {

    private String answer;

}
