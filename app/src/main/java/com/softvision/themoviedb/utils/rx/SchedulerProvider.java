package com.softvision.themoviedb.utils.rx;

import io.reactivex.*;

public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
