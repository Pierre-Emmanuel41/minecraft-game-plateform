package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishBorderMessages {
	BORDER_EXPLANATION(Border_Explanation.ENGLISH),

	NEW_BORDER_EXPLANATION(NewBorder_Explanation.ENGLISH),

	NEW_BORDER_NAME_IS_MISSING(NewBorder_NameIsMissing.ENGLISH),

	NEW_BORDER_NAME_ALREADY_TAKEN(NewBorder_NameAlreadyTaken.ENGLISH),

	NEW_BORDER_BORDER_CREATED(NewBorder_BorderCreated.ENGLISH),

	CURRENT_BORDER_EXPLANATION(CurrentBorder_Explanation.ENGLISH),

	CURRENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.ENGLISH),

	LOAD_BORDER_EXPLANATION(LoadBorder_Explanation.ENGLISH),

	LOAD_BORDER_NAME_IS_MISSING(LoadBorder_NameIsMissing.ENGLISH),

	LOAD_BORDER_BORDER_LOADED(LoadBorder_BorderLoaded.ENGLISH),

	DELETE_BORDER_EXPLANATION(DeleteBorder_Explanation.ENGLISH),

	DELETE_BORDER_NAME_IS_MISSING(DeleteBorder_NameIsMissing.ENGLISH),

	DELETE_BORDER_DID_NOT_DELETE(DeleteBorder_DidNotDelete.ENGLISH),

	DELETE_BORDER_BORDER_DELETED(DeleteBorder_BorderDeleted.ENGLISH),

	LIST_BORDER_EXPLANATION(ListBorder_Explanation.ENGLISH),

	LIST_BORDER_NO_ELEMENT(ListBorder_NoElement.ENGLISH),

	LIST_BORDER_ONE_ELEMENT(ListBorder_OneElement.ENGLISH),

	LIST_BORDER_SEVERAL_ELEMENTS(ListBorder_SeveralElements.ENGLISH),

	RENAME_BORDER_EXPLANATION(RenameBorder_Explanation.ENGLISH),

	RENAME_BORDER_NAME_IS_MISSING(RenameBorder_NameIsMissing.ENGLISH),

	RENAME_BORDER_NAME_ALREADY_TAKEN(RenameBorder_NameAlreadyTaken.ENGLISH),

	RENAME_BORDER_BORDER_RENAMED(RenameBorder_BorderRenamed.ENGLISH),

	SAVE_BORDER_EXPLANATION(SaveBorder_Explanation.ENGLISH),

	SAVE_BORDER_BORDER_SAVED(SaveBorder_BorderSaved.ENGLISH),

	WORLD_BORDER_EXPLANATION(WorldBorder_Explanation.ENGLISH),

	WORLD_BORDER_WORLD_NAME_IS_MISSING(WorldBorder_WorldNameIsMissing.ENGLISH),

	WORLD_BORDER_WORLD_DEFINED(WorldBorder_WorldDefined.ENGLISH),

	CENTER_BORDER_EXPLANATION(CenterBorder_Explanation.ENGLISH),

	CENTER_BORDER_CENTER_DEFINED(CenterBorder_CenterDefined.ENGLISH),

	INITIAL_BORDER_DIAMETER_EXPLANATION(InitialBorderDiameter_Explanation.ENGLISH),

	INITIAL_BORDER_DIAMETER_ON_TAB_COMPLETE(InitialBorderDiameter_OnTabComplete.ENGLISH),

	INITIAL_BORDER_DIAMETER_DIAMETER_IS_MISSING(InitialBorderDiameter_DiameterIsMissing.ENGLISH),

	INITIAL_BORDER_DIAMETER_NEGATIVE_DIAMETER(InitialBorderDiameter_NegativeDiameter.ENGLISH),

	INITIAL_BORDER_DIAMETER_DIAMETER_DEFINED(InitialBorderDiameter_DiameterDefined.ENGLISH),

	FINAL_BORDER_DIAMETER_EXPLANATION(FinalBorderDiameter_Explanation.ENGLISH),

	FINAL_BORDER_DIAMETER_ON_TAB_COMPLETE(FinalBorderDiameter_OnTabComplete.ENGLISH),

	FINAL_BORDER_DIAMETER_DIAMETER_IS_MISSING(FinalBorderDiameter_DiameterIsMissing.ENGLISH),

	FINAL_BORDER_DIAMETER_NEGATIVE_DIAMETER(FinalBorderDiameter_NegativeDiameter.ENGLISH),

	FINAL_BORDER_DIAMETER_DIAMETER_DEFINED(FinalBorderDiameter_DiameterDefined.ENGLISH),

	SPEED_BORDER_EXPLANATION(SpeedBorder_Explanation.ENGLISH),

	SPEED_BORDER_ON_TAB_COMPLETE(SpeedBorder_OnTabComplete.ENGLISH),

	SPEED_BORDER_SPEED_IS_MISSING(SpeedBorder_SpeedIsMissing.ENGLISH),

	SPEED_BORDER_SPEED_IS_NEGATIVE(SpeedBorder_SpeedIsNegative.ENGLISH),

	SPEED_BORDER_SPEED_DEFINED(SpeedBorder_SpeedDefined.ENGLISH),

	START_TIME_BORDER_EXPLANATION(StartTimeBorder_Explanation.ENGLISH),

	START_TIME_BORDER_TIME_IS_MISSING(StartTimeBorder_TimeIsMissing.ENGLISH),

	START_TIME_BORDER_BORDER_MOVES_AT_THE_BEGINNING(StartTimeBorder_BorderMovesAtTheBeginning.ENGLISH),

	START_TIME_BORDER_START_TIME_DEFINED(StartTimeBorder_StartTimeDefined.ENGLISH),

	MOVE_TIME_BORDER_EXPLANATION(MoveTimeBorder_Explanation.ENGLISH),

	MOVE_TIME_BORDER_TIME_IS_MISSING(MoveTimeBorder_TimeIsMissing.ENGLISH);

	private IMessage source;

	private EnglishBorderMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishBorderMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
