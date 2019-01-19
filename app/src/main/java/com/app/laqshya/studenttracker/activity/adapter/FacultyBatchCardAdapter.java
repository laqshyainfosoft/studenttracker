package com.app.laqshya.studenttracker.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.laqshya.studenttracker.activity.listeners.OnFacultyBatchClickListner;
import com.app.laqshya.studenttracker.activity.model.FacultyCourse;
import com.app.laqshya.studenttracker.databinding.FacultyAttendanceBatchesBinding;

import java.util.List;

public class FacultyBatchCardAdapter extends RecyclerView.Adapter<FacultyBatchCardAdapter.CustomViewHolder>{
    private List<FacultyCourse> facultyCourses;
    private OnFacultyBatchClickListner onFacultyBatchClickListner;

    public FacultyBatchCardAdapter(OnFacultyBatchClickListner onFacultyBatchClickListner) {
        this.onFacultyBatchClickListner = onFacultyBatchClickListner;
    }

    public void setFacultyCourses(List<FacultyCourse> facultyCourses) {
        this.facultyCourses = facultyCourses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        FacultyAttendanceBatchesBinding facultyAttendanceBatchesBinding=FacultyAttendanceBatchesBinding.inflate(
                LayoutInflater.from(viewGroup.getContext()),viewGroup,false
        );

        return new CustomViewHolder(facultyAttendanceBatchesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.bind(facultyCourses.get(i));

    }

    @Override
    public int getItemCount() {
        if(facultyCourses==null)return 0;
        else return facultyCourses.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        FacultyAttendanceBatchesBinding facultyAttendanceBatchesBinding;
        public CustomViewHolder(FacultyAttendanceBatchesBinding facultyAttendanceBatchesBinding) {
            super(facultyAttendanceBatchesBinding.getRoot());
            this.facultyAttendanceBatchesBinding=facultyAttendanceBatchesBinding;

        }
        void bind(FacultyCourse facultyCourse){
            facultyAttendanceBatchesBinding.setCourses(facultyCourse);
            facultyAttendanceBatchesBinding.executePendingBindings();
            facultyAttendanceBatchesBinding.getRoot().setOnClickListener((v -> {
                onFacultyBatchClickListner.onClickFacultyCard(facultyCourse.getBatchid());
            }));


        }
    }
}
