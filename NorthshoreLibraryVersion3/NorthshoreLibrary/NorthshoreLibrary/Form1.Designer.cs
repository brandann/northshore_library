namespace NorthshoreLibrary
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.SearchTerm2 = new System.Windows.Forms.ComboBox();
            this.SearchTerm1 = new System.Windows.Forms.ComboBox();
            this.Tabs = new System.Windows.Forms.TabControl();
            this.SearchTab = new System.Windows.Forms.TabPage();
            this.ClearTermsButton = new System.Windows.Forms.Button();
            this.SearchResultLabel = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SearchTermList = new System.Windows.Forms.ListBox();
            this.SearchResultList = new System.Windows.Forms.ListBox();
            this.SearchBox = new System.Windows.Forms.TextBox();
            this.ResultTab = new System.Windows.Forms.TabPage();
            this.ResultPrev = new System.Windows.Forms.Button();
            this.ResultNext = new System.Windows.Forms.Button();
            this.ResultList = new System.Windows.Forms.ListBox();
            this.ResultEdit = new System.Windows.Forms.Button();
            this.ResultAutocad = new System.Windows.Forms.Button();
            this.ResultPDF = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.checkBox2 = new System.Windows.Forms.CheckBox();
            this.checkBox3 = new System.Windows.Forms.CheckBox();
            this.AddDetailButton = new System.Windows.Forms.Button();
            this.SearchRemoveButton = new System.Windows.Forms.Button();
            this.SearchSearchButton = new System.Windows.Forms.Button();
            this.SearchAddButton = new System.Windows.Forms.Button();
            this.ResultPicture = new System.Windows.Forms.PictureBox();
            this.Tabs.SuspendLayout();
            this.SearchTab.SuspendLayout();
            this.ResultTab.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ResultPicture)).BeginInit();
            this.SuspendLayout();
            // 
            // SearchTerm2
            // 
            this.SearchTerm2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.SearchTerm2.FormattingEnabled = true;
            this.SearchTerm2.Location = new System.Drawing.Point(102, 50);
            this.SearchTerm2.Name = "SearchTerm2";
            this.SearchTerm2.Size = new System.Drawing.Size(300, 21);
            this.SearchTerm2.TabIndex = 0;
            this.SearchTerm2.SelectedIndexChanged += new System.EventHandler(this.SearchTerm2_SelectedIndexChanged);
            // 
            // SearchTerm1
            // 
            this.SearchTerm1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.SearchTerm1.FormattingEnabled = true;
            this.SearchTerm1.Items.AddRange(new object[] {
            "Job Name",
            "Job Number",
            "Detail Tag"});
            this.SearchTerm1.Location = new System.Drawing.Point(102, 23);
            this.SearchTerm1.Name = "SearchTerm1";
            this.SearchTerm1.Size = new System.Drawing.Size(300, 21);
            this.SearchTerm1.TabIndex = 1;
            this.SearchTerm1.SelectedIndexChanged += new System.EventHandler(this.SearchTerm1_SelectedIndexChanged);
            // 
            // Tabs
            // 
            this.Tabs.Controls.Add(this.SearchTab);
            this.Tabs.Controls.Add(this.ResultTab);
            this.Tabs.Dock = System.Windows.Forms.DockStyle.Fill;
            this.Tabs.Location = new System.Drawing.Point(0, 0);
            this.Tabs.Name = "Tabs";
            this.Tabs.SelectedIndex = 0;
            this.Tabs.Size = new System.Drawing.Size(821, 616);
            this.Tabs.TabIndex = 4;
            // 
            // SearchTab
            // 
            this.SearchTab.BackColor = System.Drawing.SystemColors.Control;
            this.SearchTab.Controls.Add(this.checkBox3);
            this.SearchTab.Controls.Add(this.checkBox2);
            this.SearchTab.Controls.Add(this.checkBox1);
            this.SearchTab.Controls.Add(this.AddDetailButton);
            this.SearchTab.Controls.Add(this.ClearTermsButton);
            this.SearchTab.Controls.Add(this.SearchResultLabel);
            this.SearchTab.Controls.Add(this.label2);
            this.SearchTab.Controls.Add(this.SearchRemoveButton);
            this.SearchTab.Controls.Add(this.SearchTermList);
            this.SearchTab.Controls.Add(this.SearchSearchButton);
            this.SearchTab.Controls.Add(this.SearchAddButton);
            this.SearchTab.Controls.Add(this.SearchResultList);
            this.SearchTab.Controls.Add(this.SearchBox);
            this.SearchTab.Controls.Add(this.SearchTerm2);
            this.SearchTab.Controls.Add(this.SearchTerm1);
            this.SearchTab.Location = new System.Drawing.Point(4, 22);
            this.SearchTab.Name = "SearchTab";
            this.SearchTab.Padding = new System.Windows.Forms.Padding(3);
            this.SearchTab.Size = new System.Drawing.Size(813, 590);
            this.SearchTab.TabIndex = 0;
            this.SearchTab.Text = "Search";
            // 
            // ClearTermsButton
            // 
            this.ClearTermsButton.Location = new System.Drawing.Point(677, 350);
            this.ClearTermsButton.Name = "ClearTermsButton";
            this.ClearTermsButton.Size = new System.Drawing.Size(75, 23);
            this.ClearTermsButton.TabIndex = 15;
            this.ClearTermsButton.Text = "Clear";
            this.ClearTermsButton.UseVisualStyleBackColor = true;
            this.ClearTermsButton.Visible = false;
            this.ClearTermsButton.Click += new System.EventHandler(this.ClearTermsButton_Click);
            // 
            // SearchResultLabel
            // 
            this.SearchResultLabel.AutoSize = true;
            this.SearchResultLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.SearchResultLabel.Location = new System.Drawing.Point(23, 568);
            this.SearchResultLabel.Name = "SearchResultLabel";
            this.SearchResultLabel.Size = new System.Drawing.Size(52, 17);
            this.SearchResultLabel.TabIndex = 14;
            this.SearchResultLabel.Text = "label1";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 13);
            this.label2.TabIndex = 13;
            this.label2.Text = "Seach By";
            // 
            // SearchTermList
            // 
            this.SearchTermList.FormattingEnabled = true;
            this.SearchTermList.Location = new System.Drawing.Point(26, 392);
            this.SearchTermList.Name = "SearchTermList";
            this.SearchTermList.Size = new System.Drawing.Size(698, 173);
            this.SearchTermList.TabIndex = 10;
            this.SearchTermList.DoubleClick += new System.EventHandler(this.SearchTermList_DoubleClick);
            // 
            // SearchResultList
            // 
            this.SearchResultList.FormattingEnabled = true;
            this.SearchResultList.Location = new System.Drawing.Point(26, 103);
            this.SearchResultList.Name = "SearchResultList";
            this.SearchResultList.Size = new System.Drawing.Size(698, 277);
            this.SearchResultList.TabIndex = 7;
            this.SearchResultList.DoubleClick += new System.EventHandler(this.SearchResultList_DoubleClick);
            // 
            // SearchBox
            // 
            this.SearchBox.Location = new System.Drawing.Point(555, 77);
            this.SearchBox.Name = "SearchBox";
            this.SearchBox.Size = new System.Drawing.Size(96, 20);
            this.SearchBox.TabIndex = 6;
            this.SearchBox.Visible = false;
            // 
            // ResultTab
            // 
            this.ResultTab.BackColor = System.Drawing.SystemColors.Control;
            this.ResultTab.Controls.Add(this.ResultPrev);
            this.ResultTab.Controls.Add(this.ResultNext);
            this.ResultTab.Controls.Add(this.ResultList);
            this.ResultTab.Controls.Add(this.ResultEdit);
            this.ResultTab.Controls.Add(this.ResultAutocad);
            this.ResultTab.Controls.Add(this.ResultPDF);
            this.ResultTab.Controls.Add(this.ResultPicture);
            this.ResultTab.Location = new System.Drawing.Point(4, 22);
            this.ResultTab.Name = "ResultTab";
            this.ResultTab.Padding = new System.Windows.Forms.Padding(3);
            this.ResultTab.Size = new System.Drawing.Size(813, 590);
            this.ResultTab.TabIndex = 1;
            this.ResultTab.Text = "Results";
            // 
            // ResultPrev
            // 
            this.ResultPrev.Location = new System.Drawing.Point(15, 467);
            this.ResultPrev.Name = "ResultPrev";
            this.ResultPrev.Size = new System.Drawing.Size(75, 23);
            this.ResultPrev.TabIndex = 10;
            this.ResultPrev.Text = "Previous";
            this.ResultPrev.UseVisualStyleBackColor = true;
            this.ResultPrev.Visible = false;
            this.ResultPrev.Click += new System.EventHandler(this.ResultPrev_Click);
            // 
            // ResultNext
            // 
            this.ResultNext.Location = new System.Drawing.Point(252, 467);
            this.ResultNext.Name = "ResultNext";
            this.ResultNext.Size = new System.Drawing.Size(75, 23);
            this.ResultNext.TabIndex = 9;
            this.ResultNext.Text = "Next";
            this.ResultNext.UseVisualStyleBackColor = true;
            this.ResultNext.Visible = false;
            this.ResultNext.Click += new System.EventHandler(this.ResultNext_Click);
            // 
            // ResultList
            // 
            this.ResultList.FormattingEnabled = true;
            this.ResultList.Location = new System.Drawing.Point(6, 6);
            this.ResultList.Name = "ResultList";
            this.ResultList.Size = new System.Drawing.Size(321, 550);
            this.ResultList.TabIndex = 8;
            this.ResultList.SelectedIndexChanged += new System.EventHandler(this.ResultList_SelectedIndexChanged);
            // 
            // ResultEdit
            // 
            this.ResultEdit.Location = new System.Drawing.Point(6, 559);
            this.ResultEdit.Name = "ResultEdit";
            this.ResultEdit.Size = new System.Drawing.Size(75, 23);
            this.ResultEdit.TabIndex = 7;
            this.ResultEdit.Text = "Edit";
            this.ResultEdit.UseVisualStyleBackColor = true;
            this.ResultEdit.Click += new System.EventHandler(this.ResultEdit_Click);
            // 
            // ResultAutocad
            // 
            this.ResultAutocad.Location = new System.Drawing.Point(132, 559);
            this.ResultAutocad.Name = "ResultAutocad";
            this.ResultAutocad.Size = new System.Drawing.Size(75, 23);
            this.ResultAutocad.TabIndex = 6;
            this.ResultAutocad.Text = "AutoCad";
            this.ResultAutocad.UseVisualStyleBackColor = true;
            this.ResultAutocad.Click += new System.EventHandler(this.ResultAutocad_Click);
            // 
            // ResultPDF
            // 
            this.ResultPDF.Location = new System.Drawing.Point(252, 559);
            this.ResultPDF.Name = "ResultPDF";
            this.ResultPDF.Size = new System.Drawing.Size(75, 23);
            this.ResultPDF.TabIndex = 5;
            this.ResultPDF.Text = "PDF";
            this.ResultPDF.UseVisualStyleBackColor = true;
            this.ResultPDF.Click += new System.EventHandler(this.ResultPDF_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(241, 9);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(390, 31);
            this.label3.TabIndex = 3;
            this.label3.Text = "Northshore Library Database";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label3.Visible = false;
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(26, 80);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(78, 17);
            this.checkBox1.TabIndex = 17;
            this.checkBox1.Text = "Northshore";
            this.checkBox1.UseVisualStyleBackColor = true;
            this.checkBox1.Visible = false;
            // 
            // checkBox2
            // 
            this.checkBox2.AutoSize = true;
            this.checkBox2.Location = new System.Drawing.Point(125, 80);
            this.checkBox2.Name = "checkBox2";
            this.checkBox2.Size = new System.Drawing.Size(72, 17);
            this.checkBox2.TabIndex = 18;
            this.checkBox2.Text = "Northclad";
            this.checkBox2.UseVisualStyleBackColor = true;
            this.checkBox2.Visible = false;
            // 
            // checkBox3
            // 
            this.checkBox3.AutoSize = true;
            this.checkBox3.Location = new System.Drawing.Point(218, 80);
            this.checkBox3.Name = "checkBox3";
            this.checkBox3.Size = new System.Drawing.Size(74, 17);
            this.checkBox3.TabIndex = 19;
            this.checkBox3.Text = "Standards";
            this.checkBox3.UseVisualStyleBackColor = true;
            this.checkBox3.Visible = false;
            // 
            // AddDetailButton
            // 
            this.AddDetailButton.Image = global::NorthshoreLibrary.Properties.Resources.dark_list___add_2x;
            this.AddDetailButton.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.AddDetailButton.Location = new System.Drawing.Point(649, 6);
            this.AddDetailButton.Name = "AddDetailButton";
            this.AddDetailButton.Size = new System.Drawing.Size(75, 75);
            this.AddDetailButton.TabIndex = 16;
            this.AddDetailButton.Text = "New Detail";
            this.AddDetailButton.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.AddDetailButton.UseVisualStyleBackColor = true;
            this.AddDetailButton.Click += new System.EventHandler(this.AddDetailButton_Click);
            // 
            // SearchRemoveButton
            // 
            this.SearchRemoveButton.Image = global::NorthshoreLibrary.Properties.Resources.dark_x_2x;
            this.SearchRemoveButton.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.SearchRemoveButton.Location = new System.Drawing.Point(730, 490);
            this.SearchRemoveButton.Name = "SearchRemoveButton";
            this.SearchRemoveButton.Size = new System.Drawing.Size(75, 75);
            this.SearchRemoveButton.TabIndex = 11;
            this.SearchRemoveButton.Text = "Remove";
            this.SearchRemoveButton.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.SearchRemoveButton.UseVisualStyleBackColor = true;
            this.SearchRemoveButton.Click += new System.EventHandler(this.SearchRemoveButton_Click);
            // 
            // SearchSearchButton
            // 
            this.SearchSearchButton.Image = global::NorthshoreLibrary.Properties.Resources.Search;
            this.SearchSearchButton.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.SearchSearchButton.Location = new System.Drawing.Point(730, 6);
            this.SearchSearchButton.Name = "SearchSearchButton";
            this.SearchSearchButton.Size = new System.Drawing.Size(75, 75);
            this.SearchSearchButton.TabIndex = 9;
            this.SearchSearchButton.Text = "Search";
            this.SearchSearchButton.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.SearchSearchButton.UseVisualStyleBackColor = true;
            this.SearchSearchButton.Click += new System.EventHandler(this.SearchSearchButton_Click);
            // 
            // SearchAddButton
            // 
            this.SearchAddButton.Image = global::NorthshoreLibrary.Properties.Resources.dark_add_2x;
            this.SearchAddButton.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.SearchAddButton.Location = new System.Drawing.Point(730, 305);
            this.SearchAddButton.Name = "SearchAddButton";
            this.SearchAddButton.Size = new System.Drawing.Size(75, 75);
            this.SearchAddButton.TabIndex = 8;
            this.SearchAddButton.Text = "Add";
            this.SearchAddButton.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.SearchAddButton.UseVisualStyleBackColor = true;
            this.SearchAddButton.Click += new System.EventHandler(this.SearchAddButton_Click);
            // 
            // ResultPicture
            // 
            this.ResultPicture.Location = new System.Drawing.Point(333, 0);
            this.ResultPicture.Name = "ResultPicture";
            this.ResultPicture.Size = new System.Drawing.Size(472, 584);
            this.ResultPicture.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.ResultPicture.TabIndex = 0;
            this.ResultPicture.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(821, 616);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.Tabs);
            this.Name = "Form1";
            this.Text = "Northshore Library Database";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.Tabs.ResumeLayout(false);
            this.SearchTab.ResumeLayout(false);
            this.SearchTab.PerformLayout();
            this.ResultTab.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.ResultPicture)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox SearchTerm2;
        private System.Windows.Forms.ComboBox SearchTerm1;
        private System.Windows.Forms.TabControl Tabs;
        private System.Windows.Forms.TabPage SearchTab;
        private System.Windows.Forms.TabPage ResultTab;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button SearchRemoveButton;
        private System.Windows.Forms.ListBox SearchTermList;
        private System.Windows.Forms.Button SearchSearchButton;
        private System.Windows.Forms.Button SearchAddButton;
        private System.Windows.Forms.ListBox SearchResultList;
        private System.Windows.Forms.TextBox SearchBox;
        private System.Windows.Forms.Button ResultPrev;
        private System.Windows.Forms.Button ResultNext;
        private System.Windows.Forms.ListBox ResultList;
        private System.Windows.Forms.Button ResultEdit;
        private System.Windows.Forms.Button ResultAutocad;
        private System.Windows.Forms.Button ResultPDF;
        private System.Windows.Forms.PictureBox ResultPicture;
        private System.Windows.Forms.Label SearchResultLabel;
        private System.Windows.Forms.Button ClearTermsButton;
        private System.Windows.Forms.Button AddDetailButton;
        private System.Windows.Forms.CheckBox checkBox3;
        private System.Windows.Forms.CheckBox checkBox2;
        private System.Windows.Forms.CheckBox checkBox1;
    }
}

