/*
 * Copyright (c) 2014-2015, Mark Mullin
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of Tango Tricorder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.ntx24.tricorder;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Supports view of pump status and instrumentation
 */
public class PumpFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pumps, container, false);
        initializeIntakeCounts(rootView);
		return rootView;
    }

    /**
     * Reset all of the display information for the status of each pump
     * @param rootView
     */
    private void initializeIntakeCounts(View rootView) {
    	displayIntakePumpStatusMsg(rootView,Tricorder.TricorderSensorStream.Session,R.id.sessionIntakeStats);
    	displayIntakePumpStatusMsg(rootView,Tricorder.TricorderSensorStream.Location,R.id.locationIntakeStats);
    	displayIntakePumpStatusMsg(rootView,Tricorder.TricorderSensorStream.Pose,R.id.poseIntakeStats);
    	displayIntakePumpStatusMsg(rootView,Tricorder.TricorderSensorStream.Points,R.id.pointsIntakeStats);
    	displayIntakePumpStatusMsg(rootView,Tricorder.TricorderSensorStream.Picture,R.id.pictureIntakeStats);
    }
    private void displayIntakePumpStatusMsg(View rootView,Tricorder.TricorderSensorStream stream,int viewId) {
    	Integer[] stats = Quaestor.Singleton().mIntakePumpCounts.get(stream);
    	TextView tv = (TextView) rootView.findViewById(viewId);
    	tv.setText(Integer.toString(stats[0]) + "/" + Integer.toString(stats[1]));
    }

}
