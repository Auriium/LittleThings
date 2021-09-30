package xyz.auriium.littlethings.conversation.jda;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import xyz.auriium.littlethings.conversation.ConversationManager;

/**
 * Default JDA transcriber with simple capabilities
 */
public class DefaultListener extends ListenerAdapter {

    private final ConversationManager<Long> manager;

    public DefaultListener(ConversationManager<Long> manager) {
        this.manager = manager;
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        manager.submitEvent(event.getUser().getIdLong(), event);
    }

    @Override
    public void onButtonClick(@NotNull ButtonClickEvent event) {
        manager.submitEvent(event.getUser().getIdLong(), event);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        manager.submitEvent(event.getAuthor().getIdLong(), event);
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        manager.submitEvent(event.getUserIdLong(), event);
    }
}
