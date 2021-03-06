package com.example.android.architecture.blueprints.todoapp.statistics;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.architecture.blueprints.todoapp.mvibase.MviResult;
import com.example.android.architecture.blueprints.todoapp.util.LceStatus;
import com.google.auto.value.AutoValue;

interface StatisticsResult extends MviResult {
    @AutoValue
    abstract class LoadStatistics implements StatisticsResult {
        @NonNull
        abstract LceStatus status();

        abstract int activeCount();

        abstract int completedCount();

        @Nullable
        abstract Throwable error();

        @NonNull
        static LoadStatistics success(int activeCount, int completedCount) {
            return new AutoValue_StatisticsResult_LoadStatistics(LceStatus.SUCCESS, activeCount,
                    completedCount, null);
        }

        @NonNull
        static LoadStatistics failure(Throwable error) {
            return new AutoValue_StatisticsResult_LoadStatistics(LceStatus.FAILURE, 0, 0, error);
        }

        @NonNull
        static LoadStatistics inFlight() {
            return new AutoValue_StatisticsResult_LoadStatistics(LceStatus.IN_FLIGHT, 0, 0, null);
        }
    }
}
