package de.synyx.android.reservator.screen.main.agenda;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import de.synyx.android.reservator.config.Registry;
import de.synyx.android.reservator.domain.MeetingRoom;
import de.synyx.android.reservator.screen.main.status.LoadRoomUseCase;
import de.synyx.android.reservator.util.SchedulerFacade;

import io.reactivex.disposables.Disposable;


public class AgendaViewModel extends ViewModel {

    private MutableLiveData<MeetingRoom> meetingRoom;
    private SchedulerFacade schedulerFacade;
    private LoadRoomUseCase loadRoomUseCase;
    private Disposable disposable;

    public AgendaViewModel() {

        schedulerFacade = Registry.get(SchedulerFacade.class);
        loadRoomUseCase = new LoadRoomUseCase();
    }

    public LiveData<MeetingRoom> getAgenda(long calendarId) {

        if (meetingRoom == null) {
            meetingRoom = new MutableLiveData<>();
            loadAgenda(calendarId);
        }

        return meetingRoom;
    }


    private void loadAgenda(long calendarId) {

        disposable =
            loadRoomUseCase.execute(calendarId) //
            .observeOn(schedulerFacade.io()) //
            .subscribeOn(schedulerFacade.mainThread()) //
            .subscribe(meetingRoom::postValue);
    }


    @Override
    protected void onCleared() {

        super.onCleared();
        disposable.dispose();
    }
}